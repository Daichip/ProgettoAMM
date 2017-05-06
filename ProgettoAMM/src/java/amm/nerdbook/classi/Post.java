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
    private int idPost;
    private String contenuto;
    private TipoPost tipo;
    
    public Post()
    {
        this.autore = null;
        this.idPost = 0;
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
     * @return the idPost
     */
    public int getIdPost() {
        return idPost;
    }

    /**
     * @param idPost the idPost to set
     */
    public void setIdPost(int idPost) {
        this.idPost = idPost;
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
