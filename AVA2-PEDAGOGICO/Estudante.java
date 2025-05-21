import java.util.*;

public class Estudante extends Pessoa {
    private String turma;
    private Map<Tarefa, Double> notas;
    private List<Tarefa> pendentes;

    public Estudante(String nome, String turma) {
        super(nome);
        this.turma = turma;
        this.notas = new HashMap<>();
        this.pendentes = new ArrayList<>();
    }

    public boolean autenticar(String nome, String turma) {
        return this.nome.equalsIgnoreCase(nome) && this.turma.equalsIgnoreCase(turma);
    }

    public void adicionarTarefa(Tarefa tarefa) {
        pendentes.add(tarefa);
    }

    public void enviarTarefa(String descricao) {
        pendentes.removeIf(t -> t.getDescricao().equalsIgnoreCase(descricao));
        System.out.println("[INFO] Tarefa enviada com sucesso.");
    }

    public void receberNota(Tarefa tarefa, double nota) {
        notas.put(tarefa, nota);
    }

    public String getTurma() {
        return turma;
    }

    public List<Tarefa> getPendentes() {
        return pendentes;
    }

    public Map<Tarefa, Double> getNotas() {
        return notas;
    }
}