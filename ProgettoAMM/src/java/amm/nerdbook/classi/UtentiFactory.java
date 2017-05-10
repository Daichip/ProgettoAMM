/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.ArrayList;

/**
 *
 * @author Davide Fara
 */
public class UtentiFactory {
    
    //Pattern Design Singleton
    private static UtentiFactory singleton;   
    private ArrayList<Utenti> listaUtenti = new ArrayList<Utenti>();
    
    private UtentiFactory()
    {
        //Utenti 
        
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
        utente1.setFrasePresentazione("I was once known as Jumpman, did you know that?");
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
        utente2.setFrasePresentazione("I was once a hero, but now I am an explorer");
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
        utente3.setFrasePresentazione("Nobody remembers me.. I am so sad");
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
        
    }
    
    public static UtentiFactory getInstance()
    {
        if(singleton == null)
            singleton = new UtentiFactory();
        
        return singleton;
    }
    
    public Utenti getUtenteById(int id)
    {
        for (Utenti utente : this.listaUtenti) 
        {
            if (utente.getId() == id) 
                return utente;
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String pass)
    {
	for(Utenti utente : this.listaUtenti)
	{
		if(utente.getUsername().equals(user) && utente.getPassword().equals(pass)) // se la combo nome e pass è corretta rendo l'ID
			return utente.getId();
	}
	
	return -1; // se alla fine non trovo il utente rendo un ID non valido
    }
    
    public ArrayList<Utenti> getListaUtenti()
    {
        return listaUtenti;
    }
    
}
