package br.com.chatanalise.websocket.converters;

import br.com.chatanalise.DateHelper;
import br.com.chatanalise.model.Mensagem;
import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MensagemEncoder implements Encoder.Text<Mensagem> {

    @Override
    public String encode( Mensagem msg ) throws EncodeException {
        return Json.createObjectBuilder()
                .add( "mensagem", DateHelper.toString( msg.getDataHora() ) )
                .add( "nomeUsuario", msg.getNomeUsuario() )
                .add( "texto", msg.getTexto() )
                .toString();
    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }
    
}
