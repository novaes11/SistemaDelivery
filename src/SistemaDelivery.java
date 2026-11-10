import entregas.EntregaService;
import notificacoes.*;
import pagamentos.*;
import pedidos.*;
import produtos.*;
import relatorios.RelatorioService;
import repositorios.PedidoRepository;
import repositorios.PedidoRepositoryImpl;

/**
 * Ponto de entrada (Main) do Sistema de Delivery.
 * Demonstra a integração completa de todos os módulos desenvolvidos em conformidade
 * com os cinco princípios do SOLID:
 * <ul>
 *   <li><b>SRP:</b> Separação entre criação, modelo de dados, exibição e persistência do pedido.</li>
 *   <li><b>OCP:</b> Flexibilidade para plugar novos meios de pagamento sem alterar o código existente.</li>
 *   <li><b>LSP:</b> Uso transparente e polimórfico das subclasses de {@link Produto} (Pizza, Hambúrguer, Bebida).</li>
 *   <li><b>ISP:</b> Interfaces específicas e segregadas para pedidos, entregas, relatórios e notificações.</li>
 *   <li><b>DIP:</b> Desacoplamento através de injeção de dependência via interfaces nos serviços.</li>
 * </ul>
 */
public class SistemaDelivery {

    /**
     * Construtor privado para evitar instanciação direta da classe executável.
     */
    private SistemaDelivery() {
    }

    /**
     * Executa a demonstração do sistema, simulando tanto um fluxo de sucesso quanto
     * a robustez no tratamento de exceções para regras de negócio violadas.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("========== SISTEMA DE DELIVERY SOLID ==========\n");

        GerenciadorPedido gerenciadorPedido = new PedidoService();
        PedidoRepository pedidoRepository = new PedidoRepositoryImpl();
        ExibidorPedido exibidorPedido = new ExibidorPedido();
        RelatorioService relatorioService = new RelatorioService();
        EntregaService entregaService = new EntregaService();

        try {
            System.out.println("--- 1. Criando Pedido e Adicionando Produtos ---");
            Pedido pedido1 = gerenciadorPedido.criarPedido(101, "Carlos Silva");

            Produto pizza = new Pizza("Calabresa Especial", 45.0, "Grande");
            Produto burger = new Hamburguer("Smash Burger Duplo", 28.5, "Ao ponto");
            Produto bebida = new Bebida("Refrigerante Cola", 8.0, 350);

            pedido1.adicionarItem(pizza);
            pedido1.adicionarItem(burger);
            pedido1.adicionarItem(bebida);

            exibidorPedido.exibir(pedido1);
            pedidoRepository.salvar(pedido1);

            System.out.println("\n--- 2. Pagamento ---");
            double total = pedido1.calcularTotal();
            Pagamento pagamentoPix = new PagamentoViaPix("carlos@email.com");
            pagamentoPix.processar(total);

            System.out.println("\n--- 3. Notificação desacoplada ---");
            Notificacao canalWhatsApp = new NotificacaoWhatsApp("+55 11 98888-7777");
            ServicoNotificacao servicoNotificacao = new ServicoNotificacao(canalWhatsApp);
            servicoNotificacao.notificar("Seu pedido foi confirmado e está sendo preparado!");

            System.out.println("\n--- 4. Entrega e Relatórios ---");
            entregaService.agendarEntrega(pedido1, "Rua das Flores, 123 - Apto 42");
            relatorioService.gerarRelatorio(pedido1);

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("[ERRO NO FLUXO PRINCIPAL]: " + e.getMessage());
        }

        System.out.println("\n========== TESTES DE VALIDAÇÕES E EXCEPTIONS ==========");

        try {
            System.out.println("\nTentando criar produto com preço negativo...");
            new Pizza("Pizza Errada", -20.0, "Média");
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        try {
            System.out.println("\nTentando pagar R$ 50,00 com apenas R$ 30,00 entregues...");
            Pagamento dinheiroInsuficiente = new PagamentoViaDinheiro(30.0);
            dinheiroInsuficiente.processar(50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        try {
            System.out.println("\nTentando instanciar ServicoNotificacao sem canal...");
            new ServicoNotificacao(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        System.out.println("\n========== FIM DA EXECUÇÃO ==========");
    }
}
