package notificacoes;

public class NotificacaoEmail implements Notificacao {
    private final String emailDestino;

    public NotificacaoEmail(String emailDestino) {
        if (emailDestino == null || !emailDestino.contains("@")) {
            throw new IllegalArgumentException("E-mail de destino inválido.");
        }
        this.emailDestino = emailDestino;
    }

    @Override
    public void enviar(String mensagem) {
        if (mensagem == null || mensagem.trim().isEmpty()) {
            throw new IllegalArgumentException("Mensagem de e-mail não pode ser vazia.");
        }
        System.out.printf("[EMAIL para %s]: %s\n", emailDestino, mensagem);
    }
}
