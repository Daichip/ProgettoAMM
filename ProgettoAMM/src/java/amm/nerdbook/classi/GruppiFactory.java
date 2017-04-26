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
public class GruppiFactory {
    
    // Pattern Design Singleton
    private static GruppiFactory singleton;   
    private ArrayList<Gruppi> listaGruppi = new ArrayList<Gruppi>();
    
    private GruppiFactory()
    {
        //Gruppi 
        
        // Plumbers
        Gruppi gruppo0 = new Gruppi();
        gruppo0.setNomeGruppo("Plumbers");
        gruppo0.setId(0);

        // Heroes of the Triforce
        Gruppi gruppo1 = new Gruppi();
        gruppo1.setNomeGruppo("Heroes of the Triforce");
        gruppo1.setId(1);
        
        // Nobodies
        Gruppi gruppo2 = new Gruppi();
        gruppo2.setNomeGruppo("Nobodies");
        gruppo2.setId(2);
        
        listaGruppi.add(gruppo0);
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
    }
    
    public static GruppiFactory getInstance()
    {
        if(singleton == null)
            singleton = new GruppiFactory();
        
        return singleton;
    }
    
    public Gruppi getUtenteById(int id)
    {
        for (Gruppi gruppo : this.listaGruppi) 
        {
            if (gruppo.getId() == id) 
                return gruppo;
        }
        return null;
    } 
    
    public Gruppi getUtenteByName(int nomeGruppo)
    {
        for (Gruppi gruppo : this.listaGruppi) 
        {
            if (gruppo.getNomeGruppo().equals(nomeGruppo))
                return gruppo;
        }
        return null;
    } 
    
}
