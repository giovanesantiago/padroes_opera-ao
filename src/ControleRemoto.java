public class ControleRemoto {

    private Comando ultimoComando;

    // O controle não sabe o que o comando faz, apenas o executa.
    public void pressionarBotao(Comando comando) {
        comando.executar();
        ultimoComando = comando;
    }

    public void pressionarDesfazer() {
        if (ultimoComando == null) {
            System.out.println("Nada para desfazer.");
            return;
        }
        ultimoComando.desfazer();
    }
}
