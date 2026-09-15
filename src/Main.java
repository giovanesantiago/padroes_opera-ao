public class Main {

    public static void main(String[] args) {
        System.out.println("=== Pedido 1: Retirada na loja ===");
        ProcessadorPedido pedido1 = new PedidoRetirada("Ana", 120.0);
        pedido1.processarPedido();

        System.out.println("\n=== Pedido 2: Delivery ===");
        ProcessadorPedido pedido2 = new PedidoDelivery("Bruno", 80.0, 6.0);
        pedido2.processarPedido();
    }
}
