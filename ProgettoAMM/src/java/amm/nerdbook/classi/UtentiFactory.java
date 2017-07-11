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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davide Fara
 */
public class UtentiFactory {
    
    //Pattern Design Singleton
    private static UtentiFactory singleton;   
    //private ArrayList<Utenti> listaUtenti = new ArrayList<Utenti>();
    protected String connectionString;
    
    private UtentiFactory()
    {
        //Utenti 
       /*
        // Davide Fara
        Utenti utente0 = new Utenti();
        utente0.setNome("Davide");
        utente0.setCognome("Fara");
        utente0.setPassword("123");
        utente0.setConfermaPassword("123");
        utente0.setFrasePresentazione("What can I say.. Hello?");
        utente0.setDataNascita("1996-05-12");
        utente0.setUrlFotoProfilo("/ProgettoAMM/Assets/adminPic.png");
        utente0.setUsername("DF");
        utente0.setId(0);

        // Mario "Mario Mario" Rossi
        Utenti utente1 = new Utenti();
        utente1.setNome("Mario");
        utente1.setCognome("Rossi");
        utente1.setPassword("123");
        utente1.setConfermaPassword("123");
        utente1.setFrasePresentazione("I was once known as Jumpman");
        utente1.setDataNascita("1981-07-09");
        utente1.setUrlFotoProfilo("/ProgettoAMM/Assets/marioRossi.jpg");
        utente1.setUsername("MMMR");
        utente1.setId(1);
        
        // Luca "Link" Verdi
        Utenti utente2 = new Utenti();
        utente2.setNome("Luca");
        utente2.setCognome("Verdi");
        utente2.setPassword("123");
        utente2.setConfermaPassword("123");
        utente2.setFrasePresentazione("I am a hero!");
        utente2.setDataNascita("1986-02-21");
        utente2.setUrlFotoProfilo("/ProgettoAMM/Assets/lucaVerdi.jpg");
        utente2.setUsername("LLV");
        utente2.setId(2);
        
        // Carlo "Shy Guy" Rossi
        Utenti utente3 = new Utenti();
        utente3.setNome("Carlo");
        utente3.setCognome("Neri");
        utente3.setPassword("123");
        utente3.setConfermaPassword("123");
        utente3.setFrasePresentazione("Nobody remembers me..");
        utente3.setDataNascita("1988-10-09");
        utente3.setUrlFotoProfilo("/ProgettoAMM/Assets/carloRossi.gif");
        utente3.setUsername("CSGR");
        utente3.setId(3);
        
        // Not Pervenuto
        Utenti utente4 = new Utenti();
        utente4.setNome("Piero");
        utente4.setCognome("Azzurri");  //Rimosso per fare in modo che risulti incompleto
        utente4.setPassword("123");
        utente4.setConfermaPassword("123");
        //utente4.setFrasePresentazione("Nobody --- me.. I am so ---");
        //utente4.setDataNascita("09-10-1988");
        //utente4.setUrlFotoProfilo("/ProgettoAMM/Assets/carloRossi.gif");
        utente4.setUsername("NP");
        utente4.setId(4);
        
        listaUtenti.add(utente0);
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);
        
        */
    }
    
    public static UtentiFactory getInstance()
    {
        if(singleton == null)
            singleton = new UtentiFactory();
        
        return singleton;
    }
    
    public Utenti getUtenteById(int id)
    {
        /*
        for (Utenti utente : this.listaUtenti) 
        {
            if (utente.getId() == id) 
                return utente;
        }
        return null;
        */
        
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "DF", "123");
            
            String query = 
                      "select * from Utenti "
                    + "where idUtente = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Utenti current = new Utenti();
                current.setId(res.getInt("idUtente"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setConfermaPassword(res.getString("confermaPassword"));
                current.setFrasePresentazione(res.getString("frasePresentazione"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                current.setUsername(res.getString("username"));
                
                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Attenzione: Utente non trovato!");
            e.printStackTrace();
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String pass)
    {
	/*
        for(Utenti utente : this.listaUtenti)
	{
		if(utente.getUsername().equals(user) && utente.getPassword().equals(pass)) // se la combo nome e pass è corretta rendo l'ID
			return utente.getId();
	}
	
	return -1; // se alla fine non trovo il utente rendo un ID non valido
        */
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "DF", "123");
            
            String query = 
                      "select idUtente from Utenti "
                    + "where username = ? and password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, user);
            stmt.setString(2, pass);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                int id = res.getInt("idUtente");

                stmt.close();
                conn.close();
                return id;
                //return 1;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Attenzione: Utente non trovato!");
            e.printStackTrace();
        }
        return -1;
        //return 1;
        
    }
    
    public ArrayList<Utenti> getListaUtenti()
    {
        ArrayList<Utenti> listaUtenti = new ArrayList<Utenti>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "DF", "123");
            
            String query = "select * from Utenti";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Utenti current = new Utenti();
                //imposto id del post
                current.setId(res.getInt("idUtente"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setConfermaPassword(res.getString("confermaPassword"));
                current.setFrasePresentazione(res.getString("frasePresentazione"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                current.setUsername(res.getString("username"));
                
                listaUtenti.add(current);
            }

            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Attenzione: Errore nell'inserimento dell'utente!");
            e.printStackTrace();
        }
        
        return listaUtenti;
    }
    
    public ArrayList<Utenti> getListaUtenti(String infoUtCercato)
    {
        ArrayList<Utenti> listaUtenti = new ArrayList<Utenti>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "DF", "123");
            
            String query = "select * from Utenti where nome like ? or cognome like ?"; /// Modificata per M5 con aggiunta del cognome
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + infoUtCercato + "%");
            stmt.setString(2, "%" + infoUtCercato + "%"); /// Aggiunta per M5
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Utenti current = new Utenti();
                //imposto id del post
                current.setId(res.getInt("idUtente"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setConfermaPassword(res.getString("confermaPassword"));
                current.setFrasePresentazione(res.getString("frasePresentazione"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                current.setUsername(res.getString("username"));
                
                listaUtenti.add(current);
            }

            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Attenzione: Errore nell'inserimento dell'utente!");
            e.printStackTrace();
        }
        
        return listaUtenti;
    }
    
    
    public void setConnectionString(String s)
    {
	this.connectionString = s;
    }
    
    public String getConnectionString()
    {
	return this.connectionString;
    }
    
    public void cancellaUtente(Utenti utente)
    {        
        ArrayList<Utenti> listaUtenti = new ArrayList<Utenti>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "DF", "123");
            // START Transaction
            conn.setAutoCommit(false);
            
            String query = "delete from Post " + "where autore = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, utente.getId());
            stmt.executeUpdate();

            query = "delete from Amicizie where follower = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, utente.getId());
            stmt.executeUpdate();
            
            query = "delete from Amicizie where followed = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, utente.getId());
            stmt.executeUpdate();
            
            query = "delete from PartecipaGruppi where follower = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, utente.getId());
            stmt.executeUpdate();
            
            query = "delete from utenti where idUtente = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, utente.getId());
            stmt.executeUpdate();
            
            // END Transaction
            conn.commit();
            stmt.close();
            conn.close();
            
       
        } catch (SQLException e) {
            System.out.println("Attenzione: Errore nella cancellazione dell'utente!");
            // In caso di errore durante la cancellazione viene alzata un'eccezione che causa il rollback
            try {
                Connection conn = DriverManager.getConnection(connectionString, "DF", "123");
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, ex);
            }            
            e.printStackTrace();
        }
        

    }
   
}


