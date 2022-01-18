package com.pack.aeroporto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente extends Persona {
	
	String email;
	String password;
	
	
}