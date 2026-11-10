package produtos;

public class Bebida extends Produto {
    private int volumeMl;

    public Bebida(String nome, double preco, int volumeMl) {
        super(nome, preco);
        if (volumeMl <= 0) {
            throw new IllegalArgumentException("O volume da bebida deve ser maior que zero.");
        }
        this.volumeMl = volumeMl;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    @Override
    public String getDescricao() {
        return String.format("Bebida %s (%dml) - R$ %.2f", nome, volumeMl, preco);
    }
}
