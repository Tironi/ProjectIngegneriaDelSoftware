package com.pack.aeroporto.model;

public class Prenotazione {
	
    private String codiceFiscale;
    private Posto posto;
    private String codiceVolo;
    
    private String getCodiceFiscale() {
        return codiceFiscale;
    }

    private Posto getPosto() {
        return posto;
    }

    private String getCodiceVolo() {
        return codiceVolo;
    }
    
    private void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    private void setPosto(Posto posto) {
        this.posto = posto;
    }

    private void setCodiceVolo(String codiceVolo) {
        this.codiceVolo = codiceVolo;
    }

}