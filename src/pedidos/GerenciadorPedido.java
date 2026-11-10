package pedidos;

/**
 * Interface responsável pela criação e gerenciamento de novos pedidos.
 * Atende ao Princípio da Segregação de Interfaces (ISP) e da Responsabilidade Única (SRP),
 * isolando a lógica de fábrica/criação do pedido das demais operações do sistema.
 */
public interface GerenciadorPedido {

    /**
     * Cria e inicializa um novo {@link Pedido}.
     *
     * @param id      Identificador único do pedido.
     * @param cliente Nome do cliente solicitante.
     * @return Uma nova instância de {@link Pedido}.
     * @throws IllegalArgumentException se os parâmetros forem inválidos.
     */
    Pedido criarPedido(int id, String cliente);
}
