package com.pack.aeroporto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Operatore {

    private String nome;
    private String cognome;
    private @Id String email;
    private String PSW;
    
    public Operatore() {
        super();
	}
    
	public Operatore(String nome, String cognome, String email, String PSW) {
        this.nome = nome;
    	this.cognome = cognome;
    	this.email = email;
    	this.PSW = PSW;
	}
    
    public String getPSW() {
        return PSW;
    }

    public void setPSW(String pSW) {
        PSW = pSW;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}