public class EstadoModoNoturno implements EstadoLampada {

    @Override
    public void pressionarBotao(Lampada lampada) {
        System.out.println("Lampada estava em modo noturno -> desligando.");
        lampada.setEstado(new EstadoDesligada());
    }

    @Override
    public String descricao() {
        return "Modo Noturno";
    }
}
