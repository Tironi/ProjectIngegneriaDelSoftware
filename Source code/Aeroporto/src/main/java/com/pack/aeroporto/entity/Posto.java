package com.pack.aeroporto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity @IdClass(PostoKey.class)
public class Posto {
	
	@Id
	private Long numero;
	
	@Id
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
	
	public Long getNumero() {
		return numero;
	}
	
	public void setNumero(Long numero) {
		this.numero = numero;
	}
}