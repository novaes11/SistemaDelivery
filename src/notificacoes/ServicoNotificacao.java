package notificacoes;

public class ServicoNotificacao {
    private final Notificacao canalNotificacao;

    public ServicoNotificacao(Notificacao canalNotificacao) {
        if (canalNotificacao == null) {
            throw new IllegalArgumentException("O canal de notificação não pode ser nulo.");
        }
        this.canalNotificacao = canalNotificacao;
    }

    public void notificar(String mensagem) {
        canalNotificacao.enviar(mensagem);
    }
}
