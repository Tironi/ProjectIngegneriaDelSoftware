package com.pack.aeroporto.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prenotazione {

	private @Id String codiceFiscale;
    //private Posto posto;
    private String codiceVolo;

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public void setCodiceVolo(String codiceVolo) {
        this.codiceVolo = codiceVolo;
    }

	public Set<Prenotazione> getPrenotaPerAmici() {
		// TODO Auto-generated method stub
		return null;
	}
}