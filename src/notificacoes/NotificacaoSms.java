package notificacoes;

public class NotificacaoSms implements Notificacao {
    private final String telefone;

    public NotificacaoSms(String telefone) {
        if (telefone == null || telefone.trim().length() < 8) {
            throw new IllegalArgumentException("Telefone para SMS inválido.");
        }
        this.telefone = telefone;
    }

    @Override
    public void enviar(String mensagem) {
        if (mensagem == null || mensagem.trim().isEmpty()) {
            throw new IllegalArgumentException("Mensagem de SMS não pode ser vazia.");
        }
        System.out.printf("[SMS para %s]: %s\n", telefone, mensagem);
    }
}
