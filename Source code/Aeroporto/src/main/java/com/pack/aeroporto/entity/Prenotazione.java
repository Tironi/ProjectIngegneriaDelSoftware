package com.pack.aeroporto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity @IdClass(PrenotazioneKey.class)
public class Prenotazione {

	@Id
	private String codiceFiscale;
	@Id
    private boolean valigiaCabina; 
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

	public boolean isValigiaCabina() {
		return valigiaCabina;
	}

	public void setValigiaCabina(boolean valigiaCabina) {
		this.valigiaCabina = valigiaCabina;
	}
}