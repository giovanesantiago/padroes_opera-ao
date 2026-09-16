public class PagamentoPix implements EstrategiaPagamento {

    private static final double DESCONTO = 0.05;

    @Override
    public double calcularTotal(double valor) {
        return valor - (valor * DESCONTO);
    }

    @Override
    public String descricao() {
        return "Pix (5% de desconto)";
    }
}
