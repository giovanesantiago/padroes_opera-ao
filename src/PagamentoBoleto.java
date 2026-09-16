public class PagamentoBoleto implements EstrategiaPagamento {

    private static final double DESCONTO = 0.02;

    @Override
    public double calcularTotal(double valor) {
        return valor - (valor * DESCONTO);
    }

    @Override
    public String descricao() {
        return "Boleto (2% de desconto)";
    }
}
