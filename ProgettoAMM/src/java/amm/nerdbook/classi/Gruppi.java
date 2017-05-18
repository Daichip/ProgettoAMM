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
public class Gruppi {
   
    private String nomeGruppo;
    private int idGruppo;
    //private Utenti[] partecipanti;
    //private int numElementi;
    
    public Gruppi()
    {
        this.nomeGruppo = "";
        this.idGruppo = -1;
        //this.partecipanti = null;
        
    }

    
    /**
     * @return the nomeGruppo
     */
    public String getNomeGruppo() {
        return nomeGruppo;
    }

    /**
     * @param nomeGruppo the nomeGruppo to set
     */
    public void setNomeGruppo(String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return idGruppo;
    }

    /**
     * @param id the idGruppo to set
     */
    public void setId(int idGruppo) {
        this.idGruppo = idGruppo;
    }
}
