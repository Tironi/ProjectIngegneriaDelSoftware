package com.pack.aeroporto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

	private @Id String codiceFiscale;
	private String nome;
    private String cognome;
    
    public Cliente(){}

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
}