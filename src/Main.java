public class Main {

    public static void main(String[] args) {
        Luz luz = new Luz();
        ArCondicionado arCondicionado = new ArCondicionado();
        ControleRemoto controle = new ControleRemoto();

        System.out.println("=== Ligando a luz ===");
        controle.pressionarBotao(new ComandoLigarLuz(luz));

        System.out.println("\n=== Ligando o ar-condicionado ===");
        controle.pressionarBotao(new ComandoLigarAr(arCondicionado));

        System.out.println("\n=== Desligando a luz ===");
        controle.pressionarBotao(new ComandoDesligarLuz(luz));

        System.out.println("\n=== Desfazendo a ultima acao (deveria ligar a luz de novo) ===");
        controle.pressionarDesfazer();
    }
}
