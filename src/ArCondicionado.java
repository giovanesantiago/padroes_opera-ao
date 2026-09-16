public class ArCondicionado {

    private boolean ligado = false;

    public void ligar() {
        ligado = true;
        System.out.println("Ar-condicionado ligado.");
    }

    public void desligar() {
        ligado = false;
        System.out.println("Ar-condicionado desligado.");
    }
}
