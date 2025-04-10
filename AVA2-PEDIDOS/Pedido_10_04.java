public class Cliente {
    String nome;
    String cpf;
    String endereco;
    String telefone;

    Cliente(String nome, String cpf, String endereço, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}
class Produto {
    String codigo;
    String descricao;
    double precoUnitario;

    Produto(String codigo, String descricao, double precoUnitario){
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoUnitario = descricao;
    }
}

class ItemPedido {
    Produto produto;
    int quantidade;
    
    ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
}

class Pedido {
    String id;
    String dataHora;
    Cliente cliente;
    String status;
    ItemPedido item1;
    Itempedido item2;

    Pedido(String id, String dataHora, Cliente cliente) {
        this.id = id;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.status = "Em processamento";

    }

    void adicionarItens(ItemPedido i1, ItemPedido i2) {
        this.Item = i1
        this.Item = i2
    }

    double calcularTotal() {
        double total = 0
        if (item1 != null) total += item1.calcularSubtotal();
        if (item2 != null) total += item2.calcularSubtotal();
        return total;
    }

    void atualizarStatus(String novoStatus) {
        status = novoStatus;
    }
}

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Guilherme Leony","12345678900", "Rua B, 456", "98888-0000");

        Produto produto1 = new Produto("B001", "Banana Prata", 5.00);
        Produto produto2 = new Produto("B002", "Banana da Terra", 6.00);

        ItemPedido item1 = new ItemPedido(produto1, 1);
        ItemPedido item1 = new ItemPedido(produto2, 2);

        Pedido pedido = new Pedido("PED002", "10/04/2025 14:00", cliente);
        pedido.adicionarItens(item1, item1);

        System.out.println("cliente: " + cliente.nome);
        System.out.println("Status: " + pedido.status);
        System.out.println("data: ", pedido.dataHora);
        System.out.println("Total: R$", + pedido.calcularTotal());

        pedido.atualizarStatus("Enviado");
        System.out.println("novo status: " + );
    }
}
