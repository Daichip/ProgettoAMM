/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Davide Fara
 */
public class PostFactory {
    
    //Pattern Design Singleton
    private static PostFactory singleton;    
    private ArrayList<Post> listaPost = new ArrayList<Post>();
    
    // Costruttore
    private PostFactory()
    {
        UtentiFactory utentiFactory = UtentiFactory.getInstance();
        
        // Generazione dei post
        Post post1 = new Post();
        post1.setAutore(utentiFactory.getUtenteById(1));
        post1.setIdPost(0);
        post1.setContenuto("Mamma Mia!");
        post1.setTipo(Post.TipoPost.TEXT);
        
        Post post2 = new Post();
        post2.setAutore(utentiFactory.getUtenteById(2));
        post2.setIdPost(1);
        post2.setContenuto("/ProgettoAMM/Assets/linkedImg.jpg  Selfie with a friend(?)");
        post2.setTipo(Post.TipoPost.IMAGE);
        
        Post post3 = new Post();
        post3.setAutore(utentiFactory.getUtenteById(3));
        post3.setIdPost(2);
        post3.setContenuto("Guarda https://en.wikipedia.org/wiki/List_of_recurring_Mario_franchise_enemies#Shy_Guy per scoprire qualcosa su di me!");
        post3.setTipo(Post.TipoPost.TEXT);
        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
    }
    
    // Metodi  
    public static PostFactory getInstance()
    {
        if(singleton == null)
            singleton = new PostFactory();
        return singleton;
    }
   
    
    public Post getPostByID(int id)
    {
        for(Post post : this.listaPost)
        {
            if(post.getIdPost() == id)
                return post;
        }
        return null;
    }
    
    
    
    public List getPostByAuthor(Utenti author)
    {
        List<Post> listaPost = new ArrayList<Post>();
        
        for(Post post : this.listaPost)
        {
            if(post.getAutore().equals(author))
                listaPost.add(post);
        }
        return listaPost;
    }
    
}
