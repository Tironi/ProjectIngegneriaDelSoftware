package com.pack.aeroporto.model;

public class Operatore {

    private String nome;
    private String cognome;
    private String email;
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
    
    private String getNome() {
        return nome;
    }

    private String getCognome() {
        return cognome;
    }

    private String getEmail() {
        return email;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setCognome(String cognome) {
        this.cognome = cognome;
    }

    private void setEmail(String email) {
        this.email = email;
    }
}