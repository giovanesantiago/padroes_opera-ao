public class ComandoDesligarLuz implements Comando {

    private final Luz luz;

    public ComandoDesligarLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void executar() {
        luz.desligar();
    }

    @Override
    public void desfazer() {
        luz.ligar();
    }
}
