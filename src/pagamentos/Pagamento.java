package pagamentos;

/**
 * Interface que define o contrato para processamento de pagamentos.
 * Atende ao Princípio Aberto/Fechado (OCP), permitindo que novas formas
 * de pagamento sejam adicionadas sem a necessidade de modificar o código existente.
 */
public interface Pagamento {

    /**
     * Processa a cobrança do valor especificado.
     *
     * @param valor Valor monetário a ser processado (deve ser maior que zero).
     * @throws IllegalArgumentException se o valor for inválido ou insuficiente.
     */
    void processar(double valor);
}
