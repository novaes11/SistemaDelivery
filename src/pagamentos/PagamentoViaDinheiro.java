package pagamentos;

public class PagamentoViaDinheiro implements Pagamento {
    private final double valorEntregue;

    public PagamentoViaDinheiro(double valorEntregue) {
        if (valorEntregue <= 0) {
            throw new IllegalArgumentException("O valor em dinheiro entregue deve ser positivo.");
        }
        this.valorEntregue = valorEntregue;
    }

    @Override
    public void processar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do pagamento em dinheiro deve ser maior que zero.");
        }
        if (valorEntregue < valor) {
            throw new IllegalArgumentException(String.format(
                    "Valor entregue (R$ %.2f) insuficiente para pagar o total de R$ %.2f.", valorEntregue, valor
            ));
        }
        double troco = valorEntregue - valor;
        System.out.printf("Pagamento de R$ %.2f recebido em dinheiro. Troco: R$ %.2f.\n", valor, troco);
    }
}
