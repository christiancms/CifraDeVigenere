package br.com.christiancms.controller;

/**
 *
 * @author christian
 */

import br.com.christiancms.model.CifraVigenere;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

@ManagedBean
public class Main {
    
    private String texto;
    private String chave;
    
    

    public String criptografar(){
        CifraVigenere cv = new CifraVigenere(getTexto(),getChave());

        System.out.println("Texto Legível: "+getTexto());
        System.out.println("Chave: "+getChave());
        this.setTexto(cv.cifrar());
        return "decifrar";
    }
    
    public String descriptografar(){
        CifraVigenere cv = new CifraVigenere(getTexto(),getChave());

        System.out.println("Texto Cifrado: "+getTexto());
        System.out.println("Chave: "+getChave());
        this.setTexto(cv.decifrar());
        return "cifrar";
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
    
    public void reset() {
        RequestContext.getCurrentInstance().reset("form:panel");
    }
}