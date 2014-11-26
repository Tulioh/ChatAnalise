package br.com.chatanalise.websocket.converters;

import br.com.chatanalise.DateHelper;
import br.com.chatanalise.model.Mensagem;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MensagemDecoder implements Decoder.Text<Mensagem> {
    
    @Override
    public void init(final EndpointConfig config) {
    }
    
    @Override
    public Mensagem decode( String msg ) throws DecodeException {
        JsonObject obj = Json.createReader( new StringReader( msg ) )
				.readObject();
        
        Mensagem mensagem = new Mensagem();
        mensagem.setDataHora( DateHelper.toDate( msg ) );
        mensagem.setNomeUsuario( obj.getString( "nomeUsuario" ) );
        mensagem.setTexto( obj.getString( "texto" ) );
        
        return mensagem;
    }
    
    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void destroy() {
    }
}
