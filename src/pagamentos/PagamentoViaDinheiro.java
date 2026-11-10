package pagamentos;

/**
 * Implementação de pagamento em dinheiro físico com cálculo de troco.
 * Implementa {@link Pagamento} respeitando o Princípio Aberto/Fechado (OCP).
 */
public class PagamentoViaDinheiro implements Pagamento {
    private final double valorEntregue;

    /**
     * Construtor para pagamento em dinheiro.
     *
     * @param valorEntregue Quantia física em dinheiro entregue pelo cliente.
     * @throws IllegalArgumentException se o valor entregue for menor ou igual a zero.
     */
    public PagamentoViaDinheiro(double valorEntregue) {
        if (valorEntregue <= 0) {
            throw new IllegalArgumentException("O valor em dinheiro entregue deve ser positivo.");
        }
        this.valorEntregue = valorEntregue;
    }

    /**
     * Processa o pagamento em dinheiro conferindo se o valor entregue cobre o total e calculando o troco.
     *
     * @param valor Valor total a ser pago.
     * @throws IllegalArgumentException se o valor entregue for insuficiente ou se o valor a pagar for inválido.
     */
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
