package com.pack.aeroporto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aereo {
    
    public @Id Long codiceAereo;
    public int num_bagagli_cabina;

    public Aereo() {
    	super();
    }
    
    public Aereo(Long cod, int num) {
    	codiceAereo = cod;
    	num_bagagli_cabina = num;
	}
    
    public Long getCodiceAereo() {
        return codiceAereo;
    }

    public int get_num_bagagli_cabina() {
        return num_bagagli_cabina;
    }

    public void CodiceAereo(Long codice) {
        this.codiceAereo = codice;
    }

    public void set_num_bagagli_cabina(int num_bagagli_cabina) {
        this.num_bagagli_cabina = num_bagagli_cabina;
    }
}