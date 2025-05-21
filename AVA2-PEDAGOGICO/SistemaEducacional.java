import java.util.Scanner;

public class SistemaEducacional {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Educador educador = new Educador("Joao", "123");

        while (true) {
            System.out.println("\n=== Bem-vindo ao Sistema Educacional ===");
            System.out.println("1. Entrar como Professor");
            System.out.println("2. Entrar como Aluno");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int escolha = scanner.nextInt(); scanner.nextLine();

            if (escolha == 0) break;

            switch (escolha) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeProf = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    String mat = scanner.nextLine();

                    if (educador.autenticar(nomeProf, mat)) {
                        menuProfessor(scanner, educador);
                    } else {
                        System.out.println("[ERRO] Dados inválidos!");
                    }
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nomeAluno = scanner.nextLine();
                    System.out.print("Turma: ");
                    String turma = scanner.nextLine();

                    Estudante est = educador.buscarEstudantePorNome(nomeAluno);
                    if (est != null && est.autenticar(nomeAluno, turma)) {
                        menuAluno(scanner, est);
                    } else {
                        System.out.println("[ERRO] Aluno não encontrado ou dados incorretos.");
                    }
                    break;
            }
        }

        scanner.close();
    }

    private static void menuProfessor(Scanner scanner, Educador educador) {
        int opcao;
        do {
            System.out.println("\n--- MENU PROFESSOR ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Criar Tarefa");
            System.out.println("3. Atribuir Nota");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt(); scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Turma: ");
                    String turma = scanner.nextLine();
                    Estudante novo = new Estudante(nome, turma);
                    educador.adicionarEstudante(novo);
                    System.out.println("[INFO] Aluno adicionado.");
                    break;
                case 2:
                    System.out.print("Descrição da tarefa: ");
                    String desc = scanner.nextLine();
                    System.out.print("Turma: ");
                    String t = scanner.nextLine();
                    Tarefa tarefa = new Tarefa(desc, t);
                    educador.criarTarefa(tarefa);

                    for (Estudante e : educador.getEstudantes()) {
                        if (e.getTurma().equalsIgnoreCase(t)) {
                            e.adicionarTarefa(tarefa);
                        }
                    }
                    System.out.println("[INFO] Tarefa criada e atribuída.");
                    break;
                case 3:
                    System.out.print("Aluno: ");
                    String alunoNome = scanner.nextLine();
                    Estudante aluno = educador.buscarEstudantePorNome(alunoNome);

                    if (aluno != null) {
                        System.out.print("Descrição da tarefa: ");
                        String tarefaDesc = scanner.nextLine();
                        Tarefa ta = null;
                        for (Tarefa tsk : educador.getTarefas()) {
                            if (tsk.getDescricao().equalsIgnoreCase(tarefaDesc)) {
                                ta = tsk;
                                break;
                            }
                        }

                        if (ta != null) {
                            System.out.print("Nota: ");
                            double nota = scanner.nextDouble(); scanner.nextLine();
                            educador.corrigirTarefa(aluno, ta, nota);
                            System.out.println("[INFO] Nota atribuída.");
                        } else {
                            System.out.println("[ERRO] Tarefa não encontrada.");
                        }
                    } else {
                        System.out.println("[ERRO] Aluno não encontrado.");
                    }
                    break;
            }
        } while (opcao != 0);
    }

    private static void menuAluno(Scanner scanner, Estudante aluno) {
        int opcao;
        do {
            System.out.println("\n--- MENU ALUNO ---");
            System.out.println("1. Ver Tarefas Pendentes");
            System.out.println("2. Enviar Tarefa");
            System.out.println("3. Ver Notas");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt(); scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Tarefas pendentes:");
                    for (Tarefa t : aluno.getPendentes()) {
                        System.out.println("- " + t.getDescricao());
                    }
                    break;
                case 2:
                    System.out.print("Descrição da tarefa a enviar: ");
                    String desc = scanner.nextLine();
                    aluno.enviarTarefa(desc);
                    break;
                case 3:
                    System.out.println("Notas:");
                    for (var entry : aluno.getNotas().entrySet()) {
                        System.out.println(entry.getKey().getDescricao() + ": " + entry.getValue());
                    }
                    break;
            }
        } while (opcao != 0);
    }
}