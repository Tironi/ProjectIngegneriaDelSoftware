package com.pack.aeroporto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Operatore extends Persona{

	private @Id String email;
    private String nome;
    private String cognome;
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
}