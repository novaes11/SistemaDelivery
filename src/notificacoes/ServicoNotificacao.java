package notificacoes;

/**
 * Serviço de alto nível responsável pelo envio de notificações aos clientes.
 * Atende ao Princípio da Inversão de Dependência (DIP), dependendo estritamente
 * da interface abstrata {@link Notificacao} recebida por injeção de dependência via construtor.
 */
public class ServicoNotificacao {
    private final Notificacao canalNotificacao;

    /**
     * Construtor que recebe a abstração do canal de notificação.
     *
     * @param canalNotificacao Instância de {@link Notificacao} (ex: WhatsApp, Email, SMS).
     * @throws IllegalArgumentException se o canal de notificação fornecido for nulo.
     */
    public ServicoNotificacao(Notificacao canalNotificacao) {
        if (canalNotificacao == null) {
            throw new IllegalArgumentException("O canal de notificação não pode ser nulo.");
        }
        this.canalNotificacao = canalNotificacao;
    }

    /**
     * Dispara o envio da notificação delegando para o canal injetado.
     *
     * @param mensagem Texto da mensagem a ser enviada.
     * @throws IllegalArgumentException se a mensagem for inválida.
     */
    public void notificar(String mensagem) {
        canalNotificacao.enviar(mensagem);
    }
}
