package entregas;

import pedidos.Pedido;

/**
 * Interface específica para gestão de entregas de pedidos.
 * Atende ao Princípio da Segregação de Interfaces (ISP), concentrando-se
 * estritamente nas regras relacionadas ao agendamento logístico de delivery.
 */
public interface GerenciadorEntrega {

    /**
     * Agenda a entrega de um pedido para determinado endereço físico.
     *
     * @param pedido   O pedido associado à entrega.
     * @param endereco O endereço de entrega completo.
     * @throws IllegalArgumentException se o pedido for nulo ou o endereço for inválido.
     */
    void agendarEntrega(Pedido pedido, String endereco);
}
