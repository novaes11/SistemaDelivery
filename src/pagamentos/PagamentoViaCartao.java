package pagamentos;

public class PagamentoViaCartao implements Pagamento {
    private final String numeroCartao;

    public PagamentoViaCartao(String numeroCartao) {
        if (numeroCartao == null || numeroCartao.trim().length() < 13) {
            throw new IllegalArgumentException("Número de cartão inválido.");
        }
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void processar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do pagamento em cartão deve ser maior que zero.");
        }
        String ultimosDigitos = numeroCartao.substring(numeroCartao.length() - 4);
        System.out.printf("Pagamento de R$ %.2f aprovado via Cartão final %s.\n", valor, ultimosDigitos);
    }
}
