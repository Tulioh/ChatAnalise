package br.com.chatanalise.websocket.servidor;

import br.com.chatanalise.model.Mensagem;
import br.com.chatanalise.websocket.converters.MensagemDecoder;
import br.com.chatanalise.websocket.converters.MensagemEncoder;
import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat", encoders = MensagemEncoder.class, decoders = MensagemDecoder.class)
public class ChatCentral {
    
    @OnOpen
    public void onOpen( Session session ) {
        System.out.println( "Um usuário entrou" );
    }
    
    public void onMessage( Session session, Mensagem mensagem ) {
        for (Session s : session.getOpenSessions()) {
            if ( s.isOpen() ) {
                try {
                    s.getBasicRemote().sendObject( mensagem );
                } catch (IOException|EncodeException ex) {
                    System.out.println("erro ao enviar a mensagem");
                }
            }
        }
    }
}
