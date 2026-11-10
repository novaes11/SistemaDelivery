package relatorios;

import pedidos.Pedido;

/**
 * Interface específica para a emissão de relatórios do sistema.
 * Atende ao Princípio da Segregação de Interfaces (ISP), definindo apenas
 * os métodos necessários para consolidar e emitir dados analíticos.
 */
public interface GeradorRelatorio {

    /**
     * Gera e imprime o relatório referente a um {@link Pedido}.
     *
     * @param pedido O pedido cuja informação será analisada.
     * @throws IllegalArgumentException se o pedido for nulo.
     */
    void gerarRelatorio(Pedido pedido);
}
