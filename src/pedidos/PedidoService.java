package pedidos;

/**
 * Serviço responsável por orquestrar a instanciação e o gerenciamento de pedidos.
 * Implementa {@link GerenciadorPedido}.
 */
public class PedidoService implements GerenciadorPedido {

    /**
     * Construtor padrão de PedidoService.
     */
    public PedidoService() {
    }

    /**
     * Cria uma nova instância de {@link Pedido}.
     *
     * @param id      Identificador único do pedido.
     * @param cliente Nome do cliente.
     * @return O pedido instanciado.
     * @throws IllegalArgumentException se o ID for menor ou igual a zero ou o cliente for nulo/vazio.
     */
    @Override
    public Pedido criarPedido(int id, String cliente) {
        return new Pedido(id, cliente);
    }
}
