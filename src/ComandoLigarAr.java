public class ComandoLigarAr implements Comando {

    private final ArCondicionado arCondicionado;

    public ComandoLigarAr(ArCondicionado arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void executar() {
        arCondicionado.ligar();
    }

    @Override
    public void desfazer() {
        arCondicionado.desligar();
    }
}
