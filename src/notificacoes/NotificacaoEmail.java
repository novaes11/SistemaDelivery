package notificacoes;

/**
 * Canal concreto de notificação via correio eletrônico (E-mail).
 * Implementa {@link Notificacao}.
 */
public class NotificacaoEmail implements Notificacao {
    private final String emailDestino;

    /**
     * Construtor para notificação por E-mail.
     *
     * @param emailDestino Endereço eletrônico do destinatário.
     * @throws IllegalArgumentException se o e-mail for nulo ou não contiver o caractere '@'.
     */
    public NotificacaoEmail(String emailDestino) {
        if (emailDestino == null || !emailDestino.contains("@")) {
            throw new IllegalArgumentException("E-mail de destino inválido.");
        }
        this.emailDestino = emailDestino;
    }

    /**
     * Envia o e-mail com a mensagem especificada.
     *
     * @param mensagem Conteúdo da mensagem a ser enviada.
     * @throws IllegalArgumentException se a mensagem for nula ou em branco.
     */
    @Override
    public void enviar(String mensagem) {
        if (mensagem == null || mensagem.trim().isEmpty()) {
            throw new IllegalArgumentException("Mensagem de e-mail não pode ser vazia.");
        }
        System.out.printf("[EMAIL para %s]: %s\n", emailDestino, mensagem);
    }
}
