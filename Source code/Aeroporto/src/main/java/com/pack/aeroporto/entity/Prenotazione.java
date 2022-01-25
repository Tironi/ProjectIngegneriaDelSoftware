package com.pack.aeroporto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity @IdClass(PrenotazioneKey.class)
public class Prenotazione {

	@Id
	private String codiceFiscale;
	@Id
	private Long codiceVolo;	
	private boolean valigiaCabina;   // 0 in cabina, 1 in stiva
    private int numPosto;
    private double pesoBagaglio;
    private boolean bigliettoPrioritario;
    private boolean pasto;
    private double prezzo;

    public Prenotazione() {}
    
    public Prenotazione(String codiceFiscale, Long codiceVolo, boolean valigiaCabina, int numPosto) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.codiceVolo = codiceVolo;
		this.valigiaCabina = valigiaCabina;
		this.numPosto = numPosto;
	}
    
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

	public boolean isValigiaCabina() {
		return valigiaCabina;
	}

	public void setValigiaCabina(boolean valigiaCabina) {
		this.valigiaCabina = valigiaCabina;
	}
	
	public boolean getValigiaCabina() {
		return valigiaCabina;
	}

	public int getNumPosto() {
		return numPosto;
	}

	public void setNumPosto(int numPosto) {
		this.numPosto = numPosto;
	}
	
	public String getCodicePrenotazione() {
		return (this.codiceFiscale + this.codiceVolo.toString());
	}

	public double getPesoBagaglio() {
		return pesoBagaglio;
	}

	public void setPesoBagaglio(double pesoBagaglio) {
		this.pesoBagaglio = pesoBagaglio;
	}

	public boolean isBigliettoPrioritario() {
		return bigliettoPrioritario;
	}

	public void setBigliettoPrioritario(boolean bPriorit) {
		this.bigliettoPrioritario = bPriorit;
	}

	public boolean isPasto() {
		return pasto;
	}

	public void setPasto(boolean pasto) {
		this.pasto = pasto;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
}