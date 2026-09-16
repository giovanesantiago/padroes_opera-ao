public class Main {

    public static void main(String[] args) {
        Lampada lampada = new Lampada();

        for (int i = 0; i < 4; i++) {
            System.out.println("Estado atual: " + lampada.getEstadoAtual());
            lampada.pressionarBotao();
            System.out.println();
        }

        System.out.println("Estado final: " + lampada.getEstadoAtual());
    }
}
