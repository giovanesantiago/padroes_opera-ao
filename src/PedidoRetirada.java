public class PedidoRetirada extends ProcessadorPedido {

    public PedidoRetirada(String cliente, double valorProdutos) {
        super(cliente, valorProdutos);
    }

    @Override
    protected double calcularFrete() {
        System.out.println("Retirada na loja: sem frete.");
        return 0.0;
    }

    @Override
    protected void finalizarPedido() {
        System.out.println("Pedido pronto para retirada. Notificando " + getCliente() + " por SMS.");
    }
}
