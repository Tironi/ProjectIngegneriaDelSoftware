package com.pack.aeroporto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aereo {
    
    public @Id Long codice;
    public int num_bagagli_cabina;

    public Aereo() {
    	super();
    }
    
    public Aereo(Long cod, int num) {
    	codice = cod;
    	num_bagagli_cabina = num;
	}
    
    public Long getCodice() {
        return codice;
    }

    public int get_num_bagagli_cabina() {
        return num_bagagli_cabina;
    }

    public void setCodice(Long codice) {
        this.codice = codice;
    }

    public void set_num_bagagli_cabina(int num_bagagli_cabina) {
        this.num_bagagli_cabina = num_bagagli_cabina;
    }
}