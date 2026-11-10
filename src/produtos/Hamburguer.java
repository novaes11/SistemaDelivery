package produtos;

/**
 * Representa um produto do tipo Hambúrguer no sistema de delivery.
 * Especialização de {@link Produto} que inclui o ponto da carne.
 */
public class Hamburguer extends Produto {
    private String pontoDaCarne;

    /**
     * Construtor para criação de um Hambúrguer.
     *
     * @param nome         Nome do hambúrguer.
     * @param preco        Preço do hambúrguer (deve ser maior que zero).
     * @param pontoDaCarne Ponto da carne (ex: "Mal passado", "Ao ponto", "Bem passado").
     * @throws IllegalArgumentException se algum argumento for inválido.
     */
    public Hamburguer(String nome, double preco, String pontoDaCarne) {
        super(nome, preco);
        if (pontoDaCarne == null || pontoDaCarne.trim().isEmpty()) {
            throw new IllegalArgumentException("O ponto da carne deve ser informado.");
        }
        this.pontoDaCarne = pontoDaCarne;
    }

    /**
     * Obtém o ponto da carne escolhido para o hambúrguer.
     *
     * @return O ponto da carne.
     */
    public String getPontoDaCarne() {
        return pontoDaCarne;
    }

    /**
     * Retorna a descrição completa do hambúrguer com o ponto de cozimento e preço formatado.
     *
     * @return Descrição detalhada do hambúrguer.
     */
    @Override
    public String getDescricao() {
        return String.format("Hambúrguer %s (Ponto: %s) - R$ %.2f", nome, pontoDaCarne, preco);
    }
}
