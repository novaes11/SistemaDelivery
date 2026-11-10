package entregas;

import pedidos.Pedido;

/**
 * Serviço responsável pela execução e agendamento logístico de entregas.
 * Implementa {@link GerenciadorEntrega}.
 */
public class EntregaService implements GerenciadorEntrega {

    /**
     * Construtor padrão de EntregaService.
     */
    public EntregaService() {
    }

    /**
     * Realiza o agendamento da entrega do pedido no endereço fornecido.
     *
     * @param pedido   O pedido a ser entregue.
     * @param endereco O endereço de entrega.
     * @throws IllegalArgumentException se o pedido for nulo ou o endereço for nulo/vazio.
     */
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
