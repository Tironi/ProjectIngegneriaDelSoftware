package com.pack.aeroporto.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prenotazione {

	private @Id String codiceFiscale;
    private Long codiceVolo;
    private int numPosto;

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public Long getCodiceVolo() {
        return codiceVolo;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public void setCodiceVolo(Long codiceVolo) {
        this.codiceVolo = codiceVolo;
    }

	public int getNumPosto() {
		return numPosto;
	}

	public void setNumPosto(int numPosto) {
		this.numPosto = numPosto;
	}
}