package com.pack.aeroporto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity @IdClass(CompagniViaggioKey.class)
public class CompagniViaggio {
	
	@Id
	private String codiceFiscaleCliente;
	@Id
	private String codiceFiscaleAmico;
	@Id
	private String codiceVolo;
    
	public String getCodiceFiscaleCliente() {
		return codiceFiscaleCliente;
	}
	
	public void setCodiceFiscaleCliente(String codiceFiscaleCliente) {
		this.codiceFiscaleCliente = codiceFiscaleCliente;
	}
	
	public String getCodiceFiscaleAmico() {
		return codiceFiscaleAmico;
	}
	
	public void setCodiceFiscaleAmico(String codiceFiscaleAmico) {
		this.codiceFiscaleAmico = codiceFiscaleAmico;
	}
	
	public String getCodiceVolo() {
		return codiceVolo;
	}
	
	public void setCodiceVolo(String codiceVolo) {
		this.codiceVolo = codiceVolo;
	}
}
