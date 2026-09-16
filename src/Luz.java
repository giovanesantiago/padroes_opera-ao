public class Luz {

    private boolean ligada = false;

    public void ligar() {
        ligada = true;
        System.out.println("Luz ligada.");
    }

    public void desligar() {
        ligada = false;
        System.out.println("Luz desligada.");
    }
}
