package entregas;

import pedidos.Pedido;

public interface GerenciadorEntrega {
    void agendarEntrega(Pedido pedido, String endereco);
}
