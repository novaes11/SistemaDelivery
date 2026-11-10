package produtos;

/**
 * Representa um produto do tipo Bebida no sistema de delivery.
 * Especialização de {@link Produto} que inclui o volume em mililitros (ml).
 */
public class Bebida extends Produto {
    private int volumeMl;

    /**
     * Construtor para criação de uma Bebida.
     *
     * @param nome     Nome da bebida.
     * @param preco    Preço da bebida (deve ser maior que zero).
     * @param volumeMl Volume em mililitros (deve ser maior que zero).
     * @throws IllegalArgumentException se algum argumento for inválido.
     */
    public Bebida(String nome, double preco, int volumeMl) {
        super(nome, preco);
        if (volumeMl <= 0) {
            throw new IllegalArgumentException("O volume da bebida deve ser maior que zero.");
        }
        this.volumeMl = volumeMl;
    }

    /**
     * Obtém o volume da bebida em mililitros.
     *
     * @return O volume em ml.
     */
    public int getVolumeMl() {
        return volumeMl;
    }

    /**
     * Retorna a descrição completa da bebida com o volume em ml e preço formatado.
     *
     * @return Descrição detalhada da bebida.
     */
    @Override
    public String getDescricao() {
        return String.format("Bebida %s (%dml) - R$ %.2f", nome, volumeMl, preco);
    }
}
