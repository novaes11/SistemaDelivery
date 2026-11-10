package repositorios;

import pedidos.Pedido;

/**
 * Contrato de persistência para pedidos.
 * Atende ao Princípio da Inversão de Dependência (DIP) e da Responsabilidade Única (SRP),
 * permitindo que a aplicação dependa desta abstração em vez de uma implementação concreta de banco.
 */
public interface PedidoRepository {

    /**
     * Persiste um {@link Pedido} na fonte de dados configurada.
     *
     * @param pedido O pedido a ser salvo.
     * @throws IllegalArgumentException se o pedido for nulo.
     * @throws IllegalStateException    se o pedido não contiver itens.
     */
    void salvar(Pedido pedido);
}
