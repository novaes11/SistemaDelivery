package relatorios;

import pedidos.Pedido;

public class RelatorioService implements GeradorRelatorio {
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
