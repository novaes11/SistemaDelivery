package notificacoes;

/**
 * Canal concreto de notificação via Short Message Service (SMS).
 * Implementa {@link Notificacao}.
 */
public class NotificacaoSms implements Notificacao {
    private final String telefone;

    /**
     * Construtor para notificação por SMS.
     *
     * @param telefone Número de telefone do destinatário.
     * @throws IllegalArgumentException se o telefone for nulo ou tiver menos de 8 caracteres.
     */
    public NotificacaoSms(String telefone) {
        if (telefone == null || telefone.trim().length() < 8) {
            throw new IllegalArgumentException("Telefone para SMS inválido.");
        }
        this.telefone = telefone;
    }

    /**
     * Envia o SMS com a mensagem especificada.
     *
     * @param mensagem Conteúdo da mensagem a ser enviada.
     * @throws IllegalArgumentException se a mensagem for nula ou em branco.
     */
    @Override
    public void enviar(String mensagem) {
        if (mensagem == null || mensagem.trim().isEmpty()) {
            throw new IllegalArgumentException("Mensagem de SMS não pode ser vazia.");
        }
        System.out.printf("[SMS para %s]: %s\n", telefone, mensagem);
    }
}
