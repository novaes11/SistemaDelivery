package pedidos;

import produtos.Produto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private final int id;
    private final String cliente;
    private final List<Produto> itens;

    public Pedido(int id, String cliente) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID do pedido deve ser positivo.");
        }
        if (cliente == null || cliente.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente é obrigatório.");
        }
        this.id = id;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto inválido para adição ao pedido.");
        }
        this.itens.add(produto);
    }

    public double calcularTotal() {
        if (itens.isEmpty()) {
            throw new IllegalStateException("O pedido não possui itens para cálculo de total.");
        }
        double total = 0.0;
        for (Produto item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Produto> getItens() {
        return Collections.unmodifiableList(itens);
    }
}
