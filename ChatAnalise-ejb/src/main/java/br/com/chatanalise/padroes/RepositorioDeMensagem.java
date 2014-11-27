package br.com.chatanalise.padroes;

import java.util.ArrayList;

public class RepositorioDeMensagem {
    private static RepositorioDeMensagem instancia;
    private final ArrayList<Mensagem> mensagens;
    
    private RepositorioDeMensagem(){
        mensagens = new ArrayList<>();
    }
    
    public static RepositorioDeMensagem obterInstancia() {
        if( instancia == null ) {
            return instancia = new RepositorioDeMensagem();
        }
        
        return instancia;
    }
    
    public void adicionarMensagem( Mensagem mensagem ) {
        mensagens.add( mensagem );
    }

    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
    }
}
