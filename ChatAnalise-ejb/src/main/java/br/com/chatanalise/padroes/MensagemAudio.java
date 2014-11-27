package br.com.chatanalise.padroes;

public class MensagemAudio implements TipoMensagem {

    @Override
    public String gerarTipoDaMensagem( Object arquivo ) {
        return "Gerando mensagem de audio";
    }
    
}
