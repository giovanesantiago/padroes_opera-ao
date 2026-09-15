public class PedidoDelivery extends ProcessadorPedido {

    private final double distanciaKm;

    public PedidoDelivery(String cliente, double valorProdutos, double distanciaKm) {
        super(cliente, valorProdutos);
        this.distanciaKm = distanciaKm;
    }

    @Override
    protected double calcularFrete() {
        double frete = distanciaKm * 1.5;
        System.out.printf("Delivery: %.1f km -> frete de R$ %.2f%n", distanciaKm, frete);
        return frete;
    }

    @Override
    protected void finalizarPedido() {
        System.out.println("Pedido enviado para entrega. Notificando " + getCliente() + " por e-mail com rastreio.");
    }
}
