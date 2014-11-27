package br.com.chatanalise.padroes;


import br.com.chatanalise.model.Mensagem;
import java.util.ArrayList;

public class RepositorioDeMensagem {
    private static RepositorioDeMensagem instancia;
    private final ArrayList<Mensagem> mensagens;
    
    private RepositorioDeMensagem(){
        instancia = new RepositorioDeMensagem();
        mensagens = new ArrayList<>();
    }
    
    public static RepositorioDeMensagem obterInstancia() {
        return instancia;
    }
    
    public void adicionarMensagem( Mensagem mensagem ) {
        mensagens.add( mensagem );
    }

    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
    }
}
