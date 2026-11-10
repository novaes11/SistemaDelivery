package notificacoes;

/**
 * Canal concreto de notificação via WhatsApp.
 * Implementa {@link Notificacao}.
 */
public class NotificacaoWhatsApp implements Notificacao {
    private final String numeroWhatsApp;

    /**
     * Construtor para notificação via WhatsApp.
     *
     * @param numeroWhatsApp Número do contato com código de área.
     * @throws IllegalArgumentException se o número for nulo ou tiver menos de 8 caracteres.
     */
    public NotificacaoWhatsApp(String numeroWhatsApp) {
        if (numeroWhatsApp == null || numeroWhatsApp.trim().length() < 8) {
            throw new IllegalArgumentException("Número de WhatsApp inválido.");
        }
        this.numeroWhatsApp = numeroWhatsApp;
    }

    /**
     * Envia mensagem pelo WhatsApp com o conteúdo especificado.
     *
     * @param mensagem Conteúdo da mensagem a ser enviada.
     * @throws IllegalArgumentException se a mensagem for nula ou em branco.
     */
    @Override
    public void enviar(String mensagem) {
        if (mensagem == null || mensagem.trim().isEmpty()) {
            throw new IllegalArgumentException("Mensagem de WhatsApp não pode ser vazia.");
        }
        System.out.printf("[WHATSAPP para %s]: %s\n", numeroWhatsApp, mensagem);
    }
}
