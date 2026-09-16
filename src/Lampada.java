public class Lampada {

    private EstadoLampada estado;

    public Lampada() {
        this.estado = new EstadoDesligada();
    }

    public void setEstado(EstadoLampada estado) {
        this.estado = estado;
    }

    // A lampada delega o comportamento inteiro para o estado atual.
    public void pressionarBotao() {
        estado.pressionarBotao(this);
    }

    public String getEstadoAtual() {
        return estado.descricao();
    }
}
