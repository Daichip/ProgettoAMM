/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    protected String connectionString;
    
    // Costruttore
    private PostFactory()
    {
        /*
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
        post2.setContenuto("Selfie with a friend(?)");
        post2.setUrlPost("Assets/linkedImg.jpg");
        post2.setTipo(Post.TipoPost.IMAGE);
        
        Post post3 = new Post();
        post3.setAutore(utentiFactory.getUtenteById(3));
        post3.setIdPost(2);
        post3.setContenuto("Guarda <a href=\"https://en.wikipedia.org/wiki/List_of_recurring_Mario_franchise_enemies#Shy_Guy\" target=\"_blank\"> https://en.wikipedia.org/wiki/List_of_recurring_Mario_franchise_enemies#Shy_Guy </a> per scoprire qualcosa su di me!");
        post3.setTipo(Post.TipoPost.TEXT);
        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        */
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
        /*
        for(Post post : this.listaPost)
        {
            if(post.getIdPost() == id)
                return post;
        }
        return null;
        */
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "DF", "123");
            
            String query = 
                      "select * from Post "
                    + "join TipoPost on Post.tipo = TipoPost.idTipoPost "
                    + "where idPost = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Post current = new Post();
                //imposto id del post
                current.setIdPost(res.getInt("idPost"));
                
                //impost il contenuto del post
                current.setContenuto(res.getString("contenuto"));
                
                //imposto il tipo del post
                current.setTipo(this.postTypeFromString(res.getString("nameTipoPost")));
                
                //imposto l'autore del post
                Utenti autore = UtentiFactory.getInstance().getUtenteById(res.getInt("author"));
                current.setAutore(autore);

                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Attenzione: Errore nella ricerca del post!");
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    public List getPostByAuthor(Utenti author)
    {
        List<Post> listaPost = new ArrayList<Post>();
        
        /*
        for(Post post : this.listaPost)
        {
            if(post.getAutore().equals(author))
            {
                listaPost.add(post);
            }
        }
        */
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "DF", "123");
            
            String query = 
                      "select * from Post "
                    + "join TipoPost on Post.tipo = TipoPost.idTipoPost "
                    + "where autore = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, author.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setIdPost(res.getInt("idPost"));
                
                //impost il contenuto del post
                current.setContenuto(res.getString("contenuto"));
                
                //impost il link del post
                current.setUrlPost(res.getString("urlPost"));
             
                //imposto il tipo del post
                current.setTipo(this.postTypeFromString(res.getString("nameTipoPost")));

                //imposto l'autore del post
                current.setAutore(author);
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Attenzione: Errore nella ricerca del post!");
            e.printStackTrace();
        }

        return listaPost;
    }
    
    public void setConnectionString(String s)
    {
	this.connectionString = s;
    }
    
    public String getConnectionString()
    {
	return this.connectionString;
    }
    
     public Post.TipoPost postTypeFromString(String type){
        
        if(type.equals("IMAGE"))
            return Post.TipoPost.IMAGE;
        
        return Post.TipoPost.TEXT;
    }
    
    private int postTypeFromEnum(Post.TipoPost type){
        //È realizzabile in modo più robusto rispetto all'hardcoding degli indici
        if(type == Post.TipoPost.TEXT)
                return 1;
            else
                return 2;
    }
    
    public void inserisciPost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "DF", "123");
            
            String query = 
                      "insert into Post (idPost, autore, contenuto, urlPost, tipo) "
                    + "values (default, ? , ? , ? , ?)";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, post.getAutore().getId());
            
            stmt.setString(2, post.getContenuto());

            stmt.setString(3, post.getUrlPost());
            
            stmt.setInt(4, this.postTypeFromEnum(post.getTipo()));
            
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Attenzione: Errore nell'inserimento del post!");
            e.printStackTrace();
        }
    }
    
    /*
    public void cancellaPostUtente(Utenti utente) throws SQLException
    {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "DF", "123");
            
            String query = "delete from Post " + "where autore = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, utente.getId());
            
            // Esecuzione query
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Attenzione: Errore nella cancellazione del post!");
            Connection conn = DriverManager.getConnection(connectionString, "DF", "123");
            conn.rollback();
            e.printStackTrace();
        }
    } 
    */
}