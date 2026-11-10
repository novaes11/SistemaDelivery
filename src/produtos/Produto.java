package produtos;

/**
 * Representa a classe base para todos os itens comercializáveis do cardápio.
 * Atende ao Princípio da Substituição de Liskov (LSP), permitindo que qualquer
 * subclasse seja utilizada polimorficamente onde um Produto for esperado.
 */
public abstract class Produto {
    /**
     * Nome identificador do produto.
     */
    protected String nome;

    /**
     * Preço unitário do produto.
     */
    protected double preco;

    /**
     * Construtor da classe base Produto.
     *
     * @param nome  Nome descritivo do produto.
     * @param preco Preço unitário do produto (deve ser estritamente maior que zero).
     * @throws IllegalArgumentException se o nome for nulo/vazio ou o preço for menor ou igual a zero.
     */
    public Produto(String nome, double preco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("O preço do produto deve ser maior que zero.");
        }
        this.nome = nome;
        this.preco = preco;
    }

    /**
     * Obtém o nome do produto.
     *
     * @return O nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o preço do produto.
     *
     * @return O preço unitário do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Retorna a descrição detalhada e formatada do produto com suas particularidades.
     *
     * @return String contendo a descrição completa do produto.
     */
    public abstract String getDescricao();
}
