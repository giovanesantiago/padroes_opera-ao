
public class InterpretadorExpressao {

    public int interpretar(String frase) {
        String[] tokens = frase.trim().split("\\s+");

        Expressao resultado = new NumeroExpressao(Integer.parseInt(tokens[0]));

        for (int i = 1; i < tokens.length; i += 2) {
            String operador = tokens[i]; 
            int valor = Integer.parseInt(tokens[i + 1]); 
            Expressao proximoNumero = new NumeroExpressao(valor);

            resultado = switch (operador) {
                case "+" -> new SomaExpressao(resultado, proximoNumero);
                case "-" -> new SubtracaoExpressao(resultado, proximoNumero);
                default -> throw new IllegalArgumentException("Operador desconhecido: " + operador);
            };
        }

        return resultado.interpretar();
    }
}
