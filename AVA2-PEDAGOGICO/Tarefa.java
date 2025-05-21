public class Tarefa {
    private String descricao;
    private String turma;

    public Tarefa(String descricao, String turma) {
        this.descricao = descricao;
        this.turma = turma;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTurma() {
        return turma;
    }

    @Override
    public String toString() {
        return descricao + " [Turma: " + turma + "]";
    }
}