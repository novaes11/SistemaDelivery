package entregas;

import pedidos.Pedido;

public class EntregaService implements GerenciadorEntrega {
    @Override
    public void agendarEntrega(Pedido pedido, String endereco) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo para agendamento de entrega.");
        }
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("O endereço de entrega é obrigatório.");
        }
        System.out.printf("Entrega do Pedido #%d agendada para: %s.\n", pedido.getId(), endereco);
    }
}
