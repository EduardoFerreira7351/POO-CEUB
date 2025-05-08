// Classe base: Pessoa
public class Pessoa {
    private String nome;
    private String cpfOuCnpj;
    private String endereco;
    private String telefone;
    private String email;

    // Construtor vazio (pode ser complementado com outro que inicialize os atributos)
    public Pessoa() {
    }

    // Construtor com parâmetros
    public Pessoa(String nome, String cpfOuCnpj, String endereco, String telefone, String email) {
        this.nome = nome;
        this.cpfOuCnpj = cpfOuCnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }
    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

// Classe Empregado: estende Pessoa
public class Empregado extends Pessoa {
    private int codigoSetor;
    private double salarioBase;
    private double imposto; // Suponha que o imposto seja representado como fração: ex. 0.1 para 10%

    public Empregado(String nome, String cpf, String email, String telefone, 
                     int codigoSetor, double salarioBase, double imposto) {
        // Como o diagrama não indica o atributo "endereço" no construtor, omitimos-o aqui.
        setNome(nome);
        setCpfOuCnpj(cpf);
        setEmail(email);
        setTelefone(telefone);
        this.codigoSetor = codigoSetor;
        this.salarioBase = salarioBase;
        this.imposto = imposto;
    }

    // Getters e Setters
    public int getCodigoSetor() {
        return codigoSetor;
    }
    public void setCodigoSetor(int codigoSetor) {
        this.codigoSetor = codigoSetor;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getImposto() {
        return imposto;
    }
    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    // Calcula o salário líquido: salárioBase - (salárioBase * imposto)
    public double calcularSalarioLiquido() {
        return salarioBase - (salarioBase * imposto);
    }

    // Exibe as informações do empregado
    public void exibirInfo() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF/CNPJ: " + getCpfOuCnpj());
        System.out.println("Email: " + getEmail());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Código Setor: " + codigoSetor);
        System.out.println("Salário Base: " + salarioBase);
        System.out.println("Imposto: " + imposto);
        System.out.println("Salário Líquido: " + calcularSalarioLiquido());
    }
}

// Classe Vendedor: estende Empregado
public class Vendedor extends Empregado {
    private double valorVendas;
    private double percentualComissao; // Representado como fração: ex. 0.05 para 5%

    public Vendedor(String nome, String cpf, String email, String telefone, 
                    int codigoSetor, double salarioBase, double imposto,
                    double valorVendas, double percentualComissao) {
        super(nome, cpf, email, telefone, codigoSetor, salarioBase, imposto);
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    // Getters e Setters
    public double getValorVendas() {
        return valorVendas;
    }
    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }
    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    // Sobrescreve o cálculo do salário líquido para incluir a comissão
    @Override
    public double calcularSalarioLiquido() {
        double salarioLiquidoBase = super.calcularSalarioLiquido();
        double bonusComissao = valorVendas * percentualComissao;
        return salarioLiquidoBase + bonusComissao;
    }

    // Exibe as informações, incluindo as específicas do vendedor
    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Valor Vendas: " + valorVendas);
        System.out.println("Percentual Comissão: " + percentualComissao);
        System.out.println("Salário Líquido com Comissão: " + calcularSalarioLiquido());
    }
}

// Classe Fornecedor: estende Pessoa
public class Fornecedor extends Pessoa {
    private double valorCredito;
    private double valorDivida;

    public Fornecedor(String nome, String cpf, String email, String telefone, 
                      double valorCredito, double valorDivida) {
        setNome(nome);
        setCpfOuCnpj(cpf);
        setEmail(email);
        setTelefone(telefone);
        this.valorCredito = valorCredito;
        this.valorDivida = valorDivida;
    }

    // Getters e Setters
    public double getValorCredito() {
        return valorCredito;
    }
    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public double getValorDivida() {
        return valorDivida;
    }
    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    // Calcula o saldo: valor de crédito menos valor da dívida
    public double obterSaldo() {
        return valorCredito - valorDivida;
    }

    // Exibe as informações do fornecedor
    public void exibirInfo() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF/CNPJ: " + getCpfOuCnpj());
        System.out.println("Email: " + getEmail());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Valor Crédito: " + valorCredito);
        System.out.println("Valor Dívida: " + valorDivida);
        System.out.println("Saldo: " + obterSaldo());
    }
}

// Classe Cliente: estende Pessoa (pode ser personalizada conforme o diagrama)
public class Cliente extends Pessoa {
    public Cliente(String nome, String cpf, String email, String telefone, String endereco) {
        setNome(nome);
        setCpfOuCnpj(cpf);
        setEmail(email);
        setTelefone(telefone);
        setEndereco(endereco);
    }

    // Exibe as informações do cliente
    public void exibirInfo() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF/CNPJ: " + getCpfOuCnpj());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Email: " + getEmail());
    }
}

// Classe Main para testar os objetos
public class Main {
    public static void main(String[] args) {
        // Instanciando um Cliente
        Cliente cliente = new Cliente("Eduardo", "12345678901", "eduardo@mail.com", "11987654321", "Rua das Flores, 100");
        
        // Instanciando um Fornecedor
        Fornecedor fornecedor = new Fornecedor("Fornecedor ABC", "98765432100", "contato@abc.com", "1133224455", 15000.0, 5000.0);
        
        // Instanciando um Empregado
        Empregado empregado = new Empregado("João Silva", "11223344556", "joao@mail.com", "11911223344", 1, 4000.0, 0.1);
        
        // Instanciando um Vendedor
        Vendedor vendedor = new Vendedor("Maria Souza", "99887766554", "maria@mail.com", "11999887766", 2, 3500.0, 0.1, 20000.0, 0.05);
        
        // Exibindo informações
        System.out.println("=== Cliente ===");
        cliente.exibirInfo();
        
        System.out.println("\n=== Fornecedor ===");
        fornecedor.exibirInfo();
        
        System.out.println("\n=== Empregado ===");
        empregado.exibirInfo();
        
        System.out.println("\n=== Vendedor ===");
        vendedor.exibirInfo();
    }
}
