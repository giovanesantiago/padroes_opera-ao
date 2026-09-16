public class Main {

    public static void main(String[] args) {
        InterpretadorExpressao interpretador = new InterpretadorExpressao();

        String[] frases = {
                "5 + 3 - 2",
                "10 - 4 + 1",
                "7"
        };

        for (String frase : frases) {
            int resultado = interpretador.interpretar(frase);
            System.out.println("\"" + frase + "\" = " + resultado);
        }
    }
}
