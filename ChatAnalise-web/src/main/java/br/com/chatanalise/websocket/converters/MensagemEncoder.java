package br.com.chatanalise.websocket.converters;

import br.com.chatanalise.DateHelper;
import br.com.chatanalise.model.Mensagem;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MensagemEncoder implements Encoder.Text<Mensagem> {

    @Override
    public String encode( Mensagem msg ) throws EncodeException {
        JsonObject value = Json.createObjectBuilder()
                .add( "mensagem", DateHelper.dateToString( msg.getDataHora() ) )
                .add( "nomeUsuario", msg.getNomeUsuario() )
                .add( "texto", msg.getTexto() )
                .build();
        
        return value.toString();
    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }
    
}
