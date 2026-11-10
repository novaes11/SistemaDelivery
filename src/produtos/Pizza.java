package produtos;

/**
 * Representa um produto do tipo Pizza no sistema de delivery.
 * Especialização de {@link Produto} que inclui tamanho específico.
 */
public class Pizza extends Produto {
    private String tamanho;

    /**
     * Construtor para criação de uma Pizza.
     *
     * @param nome    Nome da pizza (ex: "Calabresa Especial").
     * @param preco   Preço da pizza (deve ser maior que zero).
     * @param tamanho Tamanho da pizza (ex: "Pequena", "Média", "Grande").
     * @throws IllegalArgumentException se algum argumento for inválido.
     */
    public Pizza(String nome, double preco, String tamanho) {
        super(nome, preco);
        if (tamanho == null || tamanho.trim().isEmpty()) {
            throw new IllegalArgumentException("O tamanho da pizza deve ser informado.");
        }
        this.tamanho = tamanho;
    }

    /**
     * Obtém o tamanho da pizza.
     *
     * @return O tamanho da pizza.
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * Retorna a descrição completa da pizza incluindo nome, tamanho e preço formatado.
     *
     * @return Descrição detalhada da pizza.
     */
    @Override
    public String getDescricao() {
        return String.format("Pizza %s (Tamanho: %s) - R$ %.2f", nome, tamanho, preco);
    }
}
