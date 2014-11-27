package br.com.chatanalise.padroes;

import java.util.Date;

public class Mensagem {
    private Date dataHora;
    private String nomeUsuario;
    private String conteudoMensagem;
    private TipoMensagem tipoMensagem;
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    } 

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public void setConteudoMensagem(String conteudoMensagem) {
        this.conteudoMensagem = conteudoMensagem;
    }
    
    public String gerarMensagem() {
        return tipoMensagem.gerarTipoDaMensagem( conteudoMensagem );
    }

    public void setTipoMensagem(TipoMensagem tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }
}
