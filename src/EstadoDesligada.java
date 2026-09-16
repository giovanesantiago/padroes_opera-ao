public class EstadoDesligada implements EstadoLampada {

    @Override
    public void pressionarBotao(Lampada lampada) {
        System.out.println("Lampada estava desligada -> ligando em intensidade normal.");
        lampada.setEstado(new EstadoLigada());
    }

    @Override
    public String descricao() {
        return "Desligada";
    }
}
