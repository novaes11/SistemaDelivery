package pedidos;

import produtos.Produto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Entidade que representa um Pedido no sistema de delivery.
 * Atende ao Princípio da Responsabilidade Única (SRP), limitando-se a manter
 * o estado do pedido (itens e cliente) e calcular seu valor total.
 */
public class Pedido {
    private final int id;
    private final String cliente;
    private final List<Produto> itens;

    /**
     * Construtor da entidade Pedido.
     *
     * @param id      Identificador único e positivo do pedido.
     * @param cliente Nome do cliente solicitante.
     * @throws IllegalArgumentException se o ID for menor ou igual a zero ou o nome do cliente for nulo/vazio.
     */
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

    /**
     * Adiciona um produto ao pedido.
     *
     * @param produto Instância de {@link Produto} a ser adicionada.
     * @throws IllegalArgumentException se o produto fornecido for nulo.
     */
    public void adicionarItem(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto inválido para adição ao pedido.");
        }
        this.itens.add(produto);
    }

    /**
     * Calcula o somatório dos preços de todos os itens contidos no pedido.
     *
     * @return O valor total em reais (R$).
     * @throws IllegalStateException se o pedido não possuir nenhum item adicionado.
     */
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

    /**
     * Obtém o identificador do pedido.
     *
     * @return O identificador do pedido.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o nome do cliente associado ao pedido.
     *
     * @return O nome do cliente.
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Retorna a lista imutável dos itens pertencentes ao pedido.
     *
     * @return Lista unmodifiable de {@link Produto}.
     */
    public List<Produto> getItens() {
        return Collections.unmodifiableList(itens);
    }
}
