package repositorios;

import pedidos.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepositoryImpl implements PedidoRepository {
    private final List<Pedido> bancoDeDados = new ArrayList<>();

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
