package br.com.chatanalise.websocket.converters;

import br.com.chatanalise.DateHelper;
import br.com.chatanalise.padroes.Mensagem;
import br.com.chatanalise.padroes.TipoMensagem;
import br.com.chatanalise.padroes.TipoMensagemFactory;
import java.io.StringReader;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MensagemDecoder implements Decoder.Text<Mensagem> {
    
    @Override
    public Mensagem decode( String msg ) throws DecodeException {
        JsonObject obj = Json.createReader( new StringReader( msg ) )
				.readObject();
        
        Mensagem mensagem = new Mensagem();
        Date data = DateHelper.stringDateTimeToDate( obj.getString( "dataHora" ) );
        mensagem.setDataHora( data );
        mensagem.setNomeUsuario( obj.getString( "nomeUsuario" ) );
        mensagem.setConteudoMensagem( obj.getString( "conteudoMensagem" ) );
        TipoMensagem tipo = TipoMensagemFactory.getTipoMensagem(
            obj.getString( "tipoMensagem" ) );
        mensagem.setTipoMensagem( tipo );
        
        return mensagem;
    }
    
    @Override
    public void init(final EndpointConfig config) {
    }
    
    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    @Override
    public void destroy() {
    }
}
