package pedidos;

/**
 * Classe responsável exclusivamente pela formatação e exibição dos dados de um pedido.
 * Atende ao Princípio da Responsabilidade Única (SRP), separando a camada de apresentação
 * da entidade de domínio e de sua persistência.
 */
public class ExibidorPedido {

    /**
     * Construtor padrão de ExibidorPedido.
     */
    public ExibidorPedido() {
    }

    /**
     * Exibe no console os detalhes formatados de um {@link Pedido}.
     *
     * @param pedido O pedido a ser exibido.
     * @throws IllegalArgumentException se o pedido for nulo.
     */
    public void exibir(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo para exibição.");
        }

        System.out.println("========== DETALHES DO PEDIDO #" + pedido.getId() + " ==========");
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Itens:");
        for (var item : pedido.getItens()) {
            System.out.println(" - " + item.getDescricao());
        }
        System.out.printf("Total: R$ %.2f\n", pedido.calcularTotal());
        System.out.println("==============================================");
    }
}
