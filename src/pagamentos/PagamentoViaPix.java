package pagamentos;

public class PagamentoViaPix implements Pagamento {
    private final String chavePix;

    public PagamentoViaPix(String chavePix) {
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new IllegalArgumentException("Chave PIX inválida.");
        }
        this.chavePix = chavePix;
    }

    @Override
    public void processar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do pagamento em PIX deve ser maior que zero.");
        }
        System.out.printf("Pagamento de R$ %.2f concluído instantaneamente via PIX (Chave: %s).\n", valor, chavePix);
    }
}
