package pedidos;

public class ExibidorPedido {
    public void exibir(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo para exibição.");
        }

        System.out.println("========== DETALHES DO PEDIDO #" + pedido.getId() + " ==========");
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Itens:");
        for (var item : pedido.getItens()) {
            System.out.println(" - " + item.getDescricao());
        }
        System.out.printf("Total: R$ %.2f\n", pedido.calcularTotal());
        System.out.println("==============================================");
    }
}
