package produtos;

public class Pizza extends Produto {
    private String tamanho;

    public Pizza(String nome, double preco, String tamanho) {
        super(nome, preco);
        if (tamanho == null || tamanho.trim().isEmpty()) {
            throw new IllegalArgumentException("O tamanho da pizza deve ser informado.");
        }
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    @Override
    public String getDescricao() {
        return String.format("Pizza %s (Tamanho: %s) - R$ %.2f", nome, tamanho, preco);
    }
}
