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
    private int id;
    private Utenti[] partecipanti;
    //private int numElementi;
    
    public Gruppi()
    {
        this.nomeGruppo = "";
        this.id = -1;
        this.partecipanti = null;
        
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
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the partecipanti
     */
    public Utenti[] getPartecipanti() {
        return partecipanti;
    }

    /**
     * @param partecipanti the partecipanti to set
     */
    public void setPartecipanti(Utenti[] partecipanti) {
        this.partecipanti = partecipanti;
    }
}
