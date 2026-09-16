public class EstadoLigada implements EstadoLampada {

    @Override
    public void pressionarBotao(Lampada lampada) {
        System.out.println("Lampada estava ligada -> entrando em modo noturno.");
        lampada.setEstado(new EstadoModoNoturno());
    }

    @Override
    public String descricao() {
        return "Ligada";
    }
}
