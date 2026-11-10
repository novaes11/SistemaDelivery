package relatorios;

import pedidos.Pedido;

/**
 * Serviço responsável por gerar relatórios financeiros e operacionais dos pedidos.
 * Implementa {@link GeradorRelatorio}.
 */
public class RelatorioService implements GeradorRelatorio {

    /**
     * Construtor padrão de RelatorioService.
     */
    public RelatorioService() {
    }

    /**
     * Gera o relatório financeiro e estrutural do pedido fornecido.
     *
     * @param pedido O pedido objeto da análise.
     * @throws IllegalArgumentException se o pedido for nulo.
     */
    @Override
    public void gerarRelatorio(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido nulo para geração de relatório.");
        }
        System.out.println("--- RELATÓRIO FINANCEIRO DO PEDIDO #" + pedido.getId() + " ---");
        System.out.println("Qtd de Itens: " + pedido.getItens().size());
        System.out.printf("Valor Total: R$ %.2f\n", pedido.calcularTotal());
        System.out.println("----------------------------------------------");
    }
}
