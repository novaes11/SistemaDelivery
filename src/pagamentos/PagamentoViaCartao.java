package pagamentos;

/**
 * Implementação de pagamento via cartão de crédito ou débito.
 * Implementa {@link Pagamento} respeitando o Princípio Aberto/Fechado (OCP).
 */
public class PagamentoViaCartao implements Pagamento {
    private final String numeroCartao;

    /**
     * Construtor para processamento via Cartão.
     *
     * @param numeroCartao Número do cartão de crédito/débito.
     * @throws IllegalArgumentException se o número for nulo ou tiver menos de 13 dígitos.
     */
    public PagamentoViaCartao(String numeroCartao) {
        if (numeroCartao == null || numeroCartao.trim().length() < 13) {
            throw new IllegalArgumentException("Número de cartão inválido.");
        }
        this.numeroCartao = numeroCartao;
    }

    /**
     * Processa a cobrança no cartão com mascaramento dos dígitos, exibindo apenas o final.
     *
     * @param valor Valor monetário a ser debitado.
     * @throws IllegalArgumentException se o valor for menor ou igual a zero.
     */
    @Override
    public void processar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do pagamento em cartão deve ser maior que zero.");
        }
        String ultimosDigitos = numeroCartao.substring(numeroCartao.length() - 4);
        System.out.printf("Pagamento de R$ %.2f aprovado via Cartão final %s.\n", valor, ultimosDigitos);
    }
}
