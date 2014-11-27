package br.com.chatanalise.websocket.servidor;

import br.com.chatanalise.padroes.Mensagem;
import br.com.chatanalise.padroes.RepositorioDeMensagem;
import br.com.chatanalise.websocket.converters.MensagemDecoder;
import br.com.chatanalise.websocket.converters.MensagemEncoder;
import br.com.chatanalise.websocket.padroes.ListaDeMensagemHelper;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat", encoders = MensagemEncoder.class, decoders = MensagemDecoder.class)
public class ChatCentral {
    private RepositorioDeMensagem repositorio;
        
    @OnOpen
    public void onOpen( Session session ) {
        repositorio = RepositorioDeMensagem.obterInstancia();
        
        List<Mensagem> mensagens = repositorio.getMensagens();
        
        if( !mensagens.isEmpty() )
            enviarMensagem(session,
                ListaDeMensagemHelper
                    .exportarListaParaJson( mensagens ) );
    }
    
    @OnMessage
    public void onMessage( Mensagem mensagem, Session session ) {
        System.out.println("recebeu");
        repositorio.adicionarMensagem( mensagem );
        
        for( Session s : session.getOpenSessions() ) {
            enviarMensagem( s, mensagem );
        }
    }
    
    private void enviarMensagem(Session s, Object o) {
        System.out.println("enviando");
        try {
            s.getBasicRemote().sendObject( o );
        } catch (IOException|EncodeException ex) {
            System.out.println("Erro ao enviar a mensagem");
        }
    }
}
