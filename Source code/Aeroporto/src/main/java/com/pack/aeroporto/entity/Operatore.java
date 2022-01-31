package com.pack.aeroporto.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AttributeOverrides({
    @AttributeOverride(name = "codiceFiscale", column =
            @Column(name = "CF"))})
public class Operatore extends Persona{

	private String email;
    private String PSW;
    
    public Operatore() {
        super();
	}
    
	public Operatore(String email, String PSW) {
    	this.setEmail(email);
    	this.setPSW(PSW);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPSW() {
		return PSW;
	}

	public void setPSW(String pSW) {
		PSW = pSW;
	}
}