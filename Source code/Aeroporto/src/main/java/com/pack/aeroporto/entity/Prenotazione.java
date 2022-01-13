package com.pack.aeroporto.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prenotazione {

<<<<<<< Updated upstream
	private @Id String codiceFiscale;
    //private Posto posto;
    private String codiceVolo;
=======
	@Id
	private String codiceFiscale;
	@Id
    private boolean valigiaCabina; 
	
    private Long codiceVolo;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
=======

	public boolean isValigiaCabina() {
		return valigiaCabina;
	}

	public void setValigiaCabina(boolean valigiaCabina) {
		this.valigiaCabina = valigiaCabina;
	}

	public int getNumPosto() {
		return numPosto;
	}

	public void setNumPosto(int numPosto) {
		this.numPosto = numPosto;
	}
>>>>>>> Stashed changes
}