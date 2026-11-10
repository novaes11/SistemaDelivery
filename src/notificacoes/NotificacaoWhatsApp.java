package notificacoes;

public class NotificacaoWhatsApp implements Notificacao {
    private final String numeroWhatsApp;

    public NotificacaoWhatsApp(String numeroWhatsApp) {
        if (numeroWhatsApp == null || numeroWhatsApp.trim().length() < 8) {
            throw new IllegalArgumentException("Número de WhatsApp inválido.");
        }
        this.numeroWhatsApp = numeroWhatsApp;
    }

    @Override
    public void enviar(String mensagem) {
        if (mensagem == null || mensagem.trim().isEmpty()) {
            throw new IllegalArgumentException("Mensagem de WhatsApp não pode ser vazia.");
        }
        System.out.printf("[WHATSAPP para %s]: %s\n", numeroWhatsApp, mensagem);
    }
}
