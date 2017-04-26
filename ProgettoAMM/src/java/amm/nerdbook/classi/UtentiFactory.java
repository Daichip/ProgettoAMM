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
        utente0.setPassword("ProgettoAMMIsThePass");
        utente0.setConfermaPassword("ProgettoAMMIsThePass");
        utente0.setFrasePresentazione("What can I say.. Hello?");
        utente0.setDataNascita("12-05-1996");
        utente0.setUrlFotoProfilo("/ProgettoAMM/Assets/adminPic.png");
        utente0.setId(0);

        // Mario "Mario Mario" Rossi
        Utenti utente1 = new Utenti();
        utente1.setNome("Mario");
        utente1.setCognome("Rossi");
        utente1.setPassword("PrincessPeachILoveYou");
        utente1.setConfermaPassword("PrincessPeachILoveYou");
        utente1.setFrasePresentazione("I was once known as Jumpman, did you know that?");
        utente1.setDataNascita("09-07-1981");
        utente1.setUrlFotoProfilo("/ProgettoAMM/Assets/marioRossi.jpg");
        utente1.setId(1);
        
        // Luca "Link" Verdi
        Utenti utente2 = new Utenti();
        utente2.setNome("Luca");
        utente2.setCognome("Verdi");
        utente2.setPassword("ZeldaOrMipha");
        utente2.setConfermaPassword("ZeldaOrMipha");
        utente2.setFrasePresentazione("I was once a hero, but now I am an explorer");
        utente2.setDataNascita("21-02-1986");
        utente2.setUrlFotoProfilo("/ProgettoAMM/Assets/lucaVerdi.jpg");
        utente2.setId(2);
        
        // Carlo "Shy Guy" Rossi
        Utenti utente3 = new Utenti();
        utente3.setNome("Carlo");
        utente3.setCognome("Rossi");
        utente3.setPassword("IAmANobody");
        utente3.setConfermaPassword("IAmANobody");
        utente3.setFrasePresentazione("Nobody remembers me.. I am so sad");
        utente3.setDataNascita("09-10-1988");
        utente3.setUrlFotoProfilo("/ProgettoAMM/Assets/carloRossi.gif");
        utente3.setId(3);
        
        listaUtenti.add(utente0);
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
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
    
}
