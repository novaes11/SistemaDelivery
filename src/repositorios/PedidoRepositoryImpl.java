package repositorios;

import pedidos.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação em memória do repositório de pedidos.
 * Implementa {@link PedidoRepository} simulando a persistência em um banco de dados relacional ou documento.
 */
public class PedidoRepositoryImpl implements PedidoRepository {
    private final List<Pedido> bancoDeDados = new ArrayList<>();

    /**
     * Construtor padrão de PedidoRepositoryImpl.
     */
    public PedidoRepositoryImpl() {
    }

    /**
     * Salva o pedido na coleção interna de dados após validações de integridade.
     *
     * @param pedido O pedido a ser salvo.
     * @throws IllegalArgumentException se o pedido fornecido for nulo.
     * @throws IllegalStateException    se o pedido não possuir itens.
     */
    @Override
    public void salvar(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Não é possível salvar um pedido nulo.");
        }
        if (pedido.getItens().isEmpty()) {
            throw new IllegalStateException("Não é possível salvar um pedido sem itens.");
        }
        bancoDeDados.add(pedido);
        System.out.println("Pedido #" + pedido.getId() + " salvo com sucesso no banco de dados.");
    }
}
