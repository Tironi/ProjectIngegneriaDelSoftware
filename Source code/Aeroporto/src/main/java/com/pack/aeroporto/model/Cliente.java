package com.pack.aeroporto.model;

import java.util.*;
import java.time.*;

public class Cliente {
	
    private String nome;
    private String cognome;
    private String codiceFiscale;

  
    private String getNome() {
        return nome;
    }

    private String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    /**
     * All'atto della prenotazione l'utente inserisce per quante persone vuole prenotare e quante di
     * queste hanno il bagaglio a mano (da mettere in cabina se il sistema durante la prenotazione vede
     * che c'è posto). 
    *
    * @param numPersone numero di persone per cui si vuole prenota il volo
    * @param numBagagliCabina quanti bagagli a mano ci saranno (quelli da mettere in stiva non sono
    * da specificare tanto hanno lo stesso prezzo)
    * @param listaAmici 
    * @param codiceVolo
    * @param numTotBagagli
    */

    
    public void effettuaPrenotazione(int numPersone, int numBagagliCabina, List<Cliente> listaAmici, String codiceVolo, int numTotBagagli) {
    
    }
    /**
     * Il sistema verifica che il codice fiscale inserito sia presente nel databasee (ossia che l'utente abbia già
     * acquistato un biglietto e quindi ci sia effettivamente uno storico da visualizzare)
    * @param codiceFiscale
    */

    public void controlloStorico(String codiceFiscale) {
    
    }
}