package produtos;

public class Hamburguer extends Produto {
    private String pontoDaCarne;

    public Hamburguer(String nome, double preco, String pontoDaCarne) {
        super(nome, preco);
        if (pontoDaCarne == null || pontoDaCarne.trim().isEmpty()) {
            throw new IllegalArgumentException("O ponto da carne deve ser informado.");
        }
        this.pontoDaCarne = pontoDaCarne;
    }

    public String getPontoDaCarne() {
        return pontoDaCarne;
    }

    @Override
    public String getDescricao() {
        return String.format("Hambúrguer %s (Ponto: %s) - R$ %.2f", nome, pontoDaCarne, preco);
    }
}
