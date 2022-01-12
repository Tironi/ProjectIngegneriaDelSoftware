package com.pack.aeroporto.entity;

import javax.persistence.Entity;

@Entity
public class Posto {

	private int numero;
	private int codiceAereo;
    private boolean prenotato;
    
	public int getCodiceAereo() {
		return codiceAereo;
	}
	
	public void setCodiceAereo(int codiceAereo) {
		this.codiceAereo = codiceAereo;
	}
	
	public boolean isPrenotato() {
		return prenotato;
	}
	
	public void setPrenotato(boolean prenotato) {
		this.prenotato = prenotato;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
