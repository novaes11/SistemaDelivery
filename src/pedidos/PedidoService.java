package pedidos;

public class PedidoService implements GerenciadorPedido {
    @Override
    public Pedido criarPedido(int id, String cliente) {
        return new Pedido(id, cliente);
    }
}
