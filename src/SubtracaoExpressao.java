// Expressão não-terminal: combina o resultado de duas subexpressões.
public class SubtracaoExpressao implements Expressao {

    private final Expressao esquerda;
    private final Expressao direita;

    public SubtracaoExpressao(Expressao esquerda, Expressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public int interpretar() {
        return esquerda.interpretar() - direita.interpretar();
    }
}
