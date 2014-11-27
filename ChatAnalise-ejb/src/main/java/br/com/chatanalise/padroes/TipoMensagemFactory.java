package br.com.chatanalise.padroes;

public class TipoMensagemFactory {
    
    public static TipoMensagem getTipoMensagem( String tipo ) {
        switch( tipo ) {
            case "texto":
                return new MensagemTexto();
            case "audio":
                return new MensagemAudio();
            default:
                return new MensagemVideo();
        }
    }
}
