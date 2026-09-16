
public class NumeroExpressao implements Expressao {

    private final int valor;

    public NumeroExpressao(int valor) {
        this.valor = valor;
    }

    @Override
    public int interpretar() {
        return valor;
    }
}
