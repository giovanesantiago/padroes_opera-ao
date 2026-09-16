import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private final List<Double> itens = new ArrayList<>();
    private EstrategiaPagamento estrategiaPagamento;

    public void adicionarItem(double valor) {
        itens.add(valor);
    }

    public void setEstrategiaPagamento(EstrategiaPagamento estrategiaPagamento) {
        this.estrategiaPagamento = estrategiaPagamento;
    }

    // O carrinho não conhece a regra de desconto: apenas delega para a estratégia atual.
    public double finalizarCompra() {
        double subtotal = itens.stream().mapToDouble(Double::doubleValue).sum();
        double total = estrategiaPagamento.calcularTotal(subtotal);

        System.out.printf("Subtotal: R$ %.2f%n", subtotal);
        System.out.println("Forma de pagamento: " + estrategiaPagamento.descricao());
        System.out.printf("Total a pagar: R$ %.2f%n", total);

        return total;
    }
}
