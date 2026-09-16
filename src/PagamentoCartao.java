public class PagamentoCartao implements EstrategiaPagamento {

    @Override
    public double calcularTotal(double valor) {
        return valor;
    }

    @Override
    public String descricao() {
        return "Cartao de Credito (sem desconto)";
    }
}
