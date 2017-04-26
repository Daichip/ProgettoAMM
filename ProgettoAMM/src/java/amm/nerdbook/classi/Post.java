/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

/**
 *
 * @author Davide Fara
 */
public class Post {

    public enum TipoPost { TEXT, IMAGE };
    
    private Utenti autore;
    private int numPost;
    private String contenuto;
    private TipoPost tipo;
    
    public Post()
    {
        this.autore = null;
        this.numPost = 0;
        this.contenuto = "";
        this.tipo = TipoPost.TEXT;
    }
    
    
    /**
     * @return the autore
     */
    public Utenti getAutore() {
        return autore;
    }

    /**
     * @param autore the autore to set
     */
    public void setAutore(Utenti autore) {
        this.autore = autore;
    }

    /**
     * @return the numPost
     */
    public int getNumPost() {
        return numPost;
    }

    /**
     * @param numPost the numPost to set
     */
    public void setNumPost(int numPost) {
        this.numPost = numPost;
    }

    /**
     * @return the contenuto
     */
    public String getContenuto() {
        return contenuto;
    }

    /**
     * @param contenuto the contenuto to set
     */
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    /**
     * @return the tipo
     */
    public TipoPost getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoPost tipo) {
        this.tipo = tipo;
    }
    
    
    
}
