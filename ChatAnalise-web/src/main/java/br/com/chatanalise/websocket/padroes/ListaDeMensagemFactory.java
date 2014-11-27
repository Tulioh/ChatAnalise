package br.com.chatanalise.websocket.padroes;

import br.com.chatanalise.DateHelper;
import br.com.chatanalise.model.Mensagem;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;

public class ListaDeMensagemFactory {
    
    // refatorar
    public static String exportarListaParaJson( List<Mensagem> mensagens ) {
        for( Mensagem msg : mensagens ) {
            JsonObject value = Json.createObjectBuilder()
                .add( "mensagem", DateHelper.dateToString( msg.getDataHora() ) )
                .add( "nomeUsuario", msg.getNomeUsuario() )
                .add( "texto", msg.getTexto() )
                .build();
            
            Json.createArrayBuilder().add( value );
        }
        
        return Json.createArrayBuilder().build().toString();
    }
}
