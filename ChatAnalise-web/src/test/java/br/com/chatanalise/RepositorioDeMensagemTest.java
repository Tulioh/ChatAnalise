package br.com.chatanalise;

import br.com.chatanalise.padroes.RepositorioDeMensagem;
import org.junit.Test;
import static org.junit.Assert.*;

public class RepositorioDeMensagemTest {
    
    @Test
    public void asDuasInstanciasTemQueSeroMesmoObjeto() {
        RepositorioDeMensagem rep1 = RepositorioDeMensagem.obterInstancia();
        RepositorioDeMensagem rep2 = RepositorioDeMensagem.obterInstancia();
        
        assertEquals( rep1, rep2 );
    }
}
