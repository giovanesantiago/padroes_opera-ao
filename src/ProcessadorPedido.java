public abstract class ProcessadorPedido {

    private final String cliente;
    private final double valorProdutos;

    protected ProcessadorPedido(String cliente, double valorProdutos) {
        this.cliente = cliente;
        this.valorProdutos = valorProdutos;
    }

    // Template method: define o esqueleto fixo do processamento de um pedido.
    public final void processarPedido() {
        validarPedido();
        double frete = calcularFrete();
        double total = valorProdutos + frete;
        confirmarPagamento(total);
        finalizarPedido();
    }

    protected void validarPedido() {
        System.out.println("Validando pedido de " + cliente + "...");
    }

   
    protected abstract double calcularFrete();

    protected void confirmarPagamento(double total) {
        System.out.printf("Pagamento de R$ %.2f confirmado.%n", total);
    }

    protected abstract void finalizarPedido();

    protected String getCliente() {
        return cliente;
    }
}
