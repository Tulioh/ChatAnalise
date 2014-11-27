package br.com.chatanalise.websocket.servidor;

import br.com.chatanalise.model.Mensagem;
import br.com.chatanalise.padroes.RepositorioDeMensagem;
import br.com.chatanalise.websocket.converters.MensagemDecoder;
import br.com.chatanalise.websocket.converters.MensagemEncoder;
import br.com.chatanalise.websocket.padroes.ListaDeMensagemFactory;
import java.io.IOException;
import java.util.List;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat/{nomeUsuario}", encoders = MensagemEncoder.class, decoders = MensagemDecoder.class)
public class ChatCentral {
    private RepositorioDeMensagem repositorio;
    //criar um método para mudar o nome do usuário quando for repetido e testar o fiz até agora
    public ChatCentral() {
        repositorio = RepositorioDeMensagem.obterInstancia();
    }
    
    @OnOpen
    public void onOpen( Session session, @PathParam("nomeUsuario") String nomeUsuario ) {
        List<Mensagem> mensagens = repositorio.getMensagens();
        
        enviarMensagem(
            session,
            ListaDeMensagemFactory
                .exportarListaParaJson( mensagens ) );
    }
    
    @OnMessage
    public void onMessage( Mensagem mensagem, Session session ) {
        repositorio.adicionarMensagem( mensagem );
    }
    
    private void enviarMensagem( Session s, Object o ) {
        try {
            s.getBasicRemote().sendObject( o );
        } catch (IOException|EncodeException ex) {
            System.out.println("Erro ao enviar a mensagem");
        }
    }
}
