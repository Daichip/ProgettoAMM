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
public class Utenti {

    private String nome;
    private String cognome;
    private String password;
    private String confermaPassword;
    private String frasePresentazione;
    private String dataNascita;
    private String urlFotoProfilo;
    private String username;
    private int id;
    
    
    public Utenti()
    {
        this.nome = "";
        this.cognome = "";
        this.password = "";
        this.confermaPassword = "";
        this.frasePresentazione = "";
        this.dataNascita = "";
        this.urlFotoProfilo = "";
        this.username = "";
        this.id = 0;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the confermaPassword
     */
    public String getConfermaPassword() {
        return confermaPassword;
    }

    /**
     * @param confermaPassword the confermaPassword to set
     */
    public void setConfermaPassword(String confermaPassword) {
        this.confermaPassword = confermaPassword;
    }

    /**
     * @return the frasePresentazione
     */
    public String getFrasePresentazione() {
        return frasePresentazione;
    }

    /**
     * @param frasePresentazione the frasePresentazione to set
     */
    public void setFrasePresentazione(String frasePresentazione) {
        this.frasePresentazione = frasePresentazione;
    }

    /**
     * @return the dataNascita
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /**
     * @param dataNascita the dataNascita to set
     */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }   

    /**
     * @return the urlFotoProfilo
     */
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    /**
     * @param urlFotoProfilo the urlFotoProfilo to set
     */
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    
    @Override
    public boolean equals(Object altroUtente)
    {
        if(altroUtente instanceof Utenti)
            if(this.getId() == ((Utenti)altroUtente).getId()) return true;
        return false;
    }
    
    public String getNomeById(int id) {
        return nome;
    }
    
    public String getCognomeById(int id) {
        return cognome;
    }
}
