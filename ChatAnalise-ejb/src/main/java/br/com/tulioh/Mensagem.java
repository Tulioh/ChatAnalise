/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tulioh;

import java.util.Date;

/**
 *
 * @author JOAOPAULO
 */
public class Mensagem {
    
    private String texto;
    private Date dataHora;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    private String nomeUsuario;
    
    
}
