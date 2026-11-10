package pagamentos;

/**
 * Implementação de pagamento instantâneo via PIX.
 * Implementa {@link Pagamento} respeitando o Princípio Aberto/Fechado (OCP).
 */
public class PagamentoViaPix implements Pagamento {
    private final String chavePix;

    /**
     * Construtor para processamento via PIX.
     *
     * @param chavePix Chave PIX destinatária (CPF, e-mail, telefone ou chave aleatória).
     * @throws IllegalArgumentException se a chave for nula ou vazia.
     */
    public PagamentoViaPix(String chavePix) {
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new IllegalArgumentException("Chave PIX inválida.");
        }
        this.chavePix = chavePix;
    }

    /**
     * Processa a transferência instantânea via PIX.
     *
     * @param valor Valor monetário a ser transferido.
     * @throws IllegalArgumentException se o valor for menor ou igual a zero.
     */
    @Override
    public void processar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do pagamento em PIX deve ser maior que zero.");
        }
        System.out.printf("Pagamento de R$ %.2f concluído instantaneamente via PIX (Chave: %s).\n", valor, chavePix);
    }
}
