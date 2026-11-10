package notificacoes;

/**
 * Interface que abstrai o envio de mensagens e notificações.
 * Atende ao Princípio da Inversão de Dependência (DIP) e da Segregação de Interfaces (ISP),
 * permitindo que o sistema dependa desta abstração e suporte múltiplos canais desacoplados.
 */
public interface Notificacao {

    /**
     * Envia uma notificação com o conteúdo informado.
     *
     * @param mensagem Texto descritivo da notificação.
     * @throws IllegalArgumentException se a mensagem for nula ou vazia.
     */
    void enviar(String mensagem);
}
