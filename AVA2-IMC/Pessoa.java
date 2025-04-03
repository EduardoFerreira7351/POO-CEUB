public class Pessoa {

    private String nome;
    private double peso;
    private double altura;

    public Pessoa(String nome, double peso, doube altura) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }
    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public String analisaIMC(double imc) {
        if (imc < 18.5) {
            return "Baixo peso. Recomendado procurar um médico para avaliação criteriosa.";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Peso adequado. Avalie outros parâmetros de composição corporal.";
        } else if (imc >= 25 && imc <= 29.9) {
            return "Sobrepeso. Risco de doenças como diabetes e hipertensão. Consulte um médico.";
        } else if (imc >= 30 && imc <= 34.9) {
            return "Obesidade grau 1. busque orientação médica e nutricional.";
        } else if (imc >= 35 && imc <= 39.9) {
            return "Obesidade grau 2. Quadro de obesidade evoluído. Busque orientação médica.";
        } else {
            return "Obesidade grau 3. alto risco de doenças associadas. busque orientação médica urgente.";
        }
    }

    public void mostrarResultado() {
        double imc = calcularumc();
        String analise = analisarIMC(imc);

        System.out.println(x"\n=== Resultado do IMC ===");
        System.out.println("nome:" + nome);
        System.out.printf(format: "IMC: %.2f kg/m²\n", imc);
        System.out.println("Análise: " + analise);
    }
}