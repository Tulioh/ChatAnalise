package br.com.chatanalise.padroes;

public class MensagemTexto implements TipoMensagem {

    @Override
    public String gerarTipoDaMensagem(Object texto) {
        return (String) texto;
    }
    
}
