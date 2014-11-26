package br.com.chatanalise.websocket;

import br.com.chatanalise.model.Mensagem;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MensagemDecoder implements Decoder.Text<Mensagem> {
    
    @Override
    public void init(final EndpointConfig config) {
        
    }
    
    @Override
    public Mensagem decode(String s) throws DecodeException {
        
    }
    
    @Override
    public boolean willDecode(final String s) {
        return true;
    }

    @Override
    public void destroy() {
    }
}
