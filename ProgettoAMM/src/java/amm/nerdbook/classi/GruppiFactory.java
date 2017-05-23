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

/**
 *
 * @author Davide Fara
 */
public class GruppiFactory {
    
    // Pattern Design Singleton
    private static GruppiFactory singleton;   
    private ArrayList<Gruppi> listaGruppi = new ArrayList<Gruppi>();
    protected String connectionString;
    
    private GruppiFactory()
    {
        //Gruppi 
        /*
        // Plumbers
        Gruppi gruppo0 = new Gruppi();
        gruppo0.setNomeGruppo("Plumbers");
        gruppo0.setDescrizione("Il meglio del peggio direttamente dal Mushroom Kingdom!");
        gruppo0.setId(0);

        // Heroes of the Triforce
        Gruppi gruppo1 = new Gruppi();
        gruppo1.setNomeGruppo("Heroes of the Triforce");
        gruppo1.setDescrizione("Un gruppo per tutti quelli che hanno ucciso Ganon");
        gruppo1.setId(1);
        
        // Nobodies
        Gruppi gruppo2 = new Gruppi();
        gruppo2.setNomeGruppo("Nobodies");
        gruppo2.setDescrizione("Un gruppo per me e basta... Son solo anche qui");
        gruppo2.setId(2);
        
        listaGruppi.add(gruppo0);
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
*/
    }
    
    public static GruppiFactory getInstance()
    {
        if(singleton == null)
            singleton = new GruppiFactory();
        
        return singleton;
    }
    
    public Gruppi getGruppoById(int id)
    {
        for (Gruppi gruppo : this.listaGruppi) 
        {
            if (gruppo.getId() == id) 
                return gruppo;
        }
        return null;
    } 
    
    public Gruppi getGruppoByName(int nomeGruppo)
    {
        for (Gruppi gruppo : this.listaGruppi) 
        {
            if (gruppo.getNomeGruppo().equals(nomeGruppo))
                return gruppo;
        }
        return null;
    } 
    
    
    public void setConnectionString(String s)
    {
	this.connectionString = s;
    }
    
    public String getConnectionString()
    {
	return this.connectionString;
    }
    
    public ArrayList<Gruppi> getListaGruppi()
    {
        ArrayList<Gruppi> listaGruppi = new ArrayList();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "DF", "123");
            
            String query = "select * from Gruppi";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                /* private String nomeGruppo;
    private String descrizione;
    private int idGruppo;
    private ArrayList<Utenti> partecipanti; */
                
                Gruppi current = new Gruppi();
                //imposto id del post
                current.setId(res.getInt("idGruppo"));
                current.setNomeGruppo(res.getString("nomeGruppo"));
                current.setDescrizione(res.getString("descrizione"));
                
                listaGruppi.add(current);
            }

            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaGruppi;
    }
}
