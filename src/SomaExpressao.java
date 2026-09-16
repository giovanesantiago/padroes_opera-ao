// Expressão não-terminal: combina o resultado de duas subexpressões.
public class SomaExpressao implements Expressao {

    private final Expressao esquerda;
    private final Expressao direita;

    public SomaExpressao(Expressao esquerda, Expressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public int interpretar() {
        return esquerda.interpretar() + direita.interpretar();
    }
}
