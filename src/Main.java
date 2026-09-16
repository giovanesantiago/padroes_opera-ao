public class Main {

    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarItem(150.0);
        carrinho.adicionarItem(89.90);

        System.out.println("=== Fechando com Cartao de Credito ===");
        carrinho.setEstrategiaPagamento(new PagamentoCartao());
        carrinho.finalizarCompra();

        System.out.println("\n=== Fechando com Pix ===");
        carrinho.setEstrategiaPagamento(new PagamentoPix());
        carrinho.finalizarCompra();

        System.out.println("\n=== Fechando com Boleto ===");
        carrinho.setEstrategiaPagamento(new PagamentoBoleto());
        carrinho.finalizarCompra();
    }
}
