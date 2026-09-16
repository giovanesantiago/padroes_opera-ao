public class ComandoDesligarAr implements Comando {

    private final ArCondicionado arCondicionado;

    public ComandoDesligarAr(ArCondicionado arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void executar() {
        arCondicionado.desligar();
    }

    @Override
    public void desfazer() {
        arCondicionado.ligar();
    }
}
