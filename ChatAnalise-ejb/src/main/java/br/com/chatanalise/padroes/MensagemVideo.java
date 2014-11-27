package br.com.chatanalise.padroes;

public class MensagemVideo implements TipoMensagem {

    @Override
    public String gerarTipoDaMensagem(Object arquivo) {
        return "Enviando mensagem de video";
    }
    
}
