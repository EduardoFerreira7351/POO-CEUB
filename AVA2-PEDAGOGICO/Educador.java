import java.util.ArrayList;
import java.util.List;

public class Educador extends Pessoa {
    private String matricula;
    private List<Estudante> estudantes;
    private List<Tarefa> tarefas;

    public Educador(String nome, String matricula) {
        super(nome);
        this.matricula = matricula;
        this.estudantes = new ArrayList<>();
        this.tarefas = new ArrayList<>();
    }

    public boolean autenticar(String nome, String matricula) {
        return this.nome.equalsIgnoreCase(nome) && this.matricula.equalsIgnoreCase(matricula);
    }

    public void adicionarEstudante(Estudante estudante) {
        estudantes.add(estudante);
    }

    public void criarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void corrigirTarefa(Estudante estudante, Tarefa tarefa, double nota) {
        estudante.receberNota(tarefa, nota);
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public Estudante buscarEstudantePorNome(String nome) {
        for (Estudante e : estudantes) {
            if (e.getNome().equalsIgnoreCase(nome)) return e;
        }
        return null;
    }
}