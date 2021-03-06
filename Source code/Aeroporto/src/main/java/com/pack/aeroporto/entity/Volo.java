package com.pack.aeroporto.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import java.time.*;
import java.util.Date;

@Entity
public class Volo {

    public Volo(Long codiceVolo, String aeroportoPartenza, String aeroportoArrivo, Date orario, Long codiceAereo,
			double prezzo, int postiDisp) {
		super();
		this.codiceVolo = codiceVolo;
		this.aeroportoPartenza = aeroportoPartenza;
		this.aeroportoArrivo = aeroportoArrivo;
		this.orario = orario;
		this.codiceAereo = codiceAereo;
		this.prezzo = prezzo;
		this.postiDisp = postiDisp;
	}
    
    public Volo() {}

	private @Id @GeneratedValue Long codiceVolo;
    private String aeroportoPartenza;
    private String aeroportoArrivo;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date orario;
    private Long codiceAereo;
    private double prezzo;
    private int postiDisp;

    public Long getCodiceVolo() {
        return codiceVolo;
    }
    
    public String getAeroportoPartenza() {
		return aeroportoPartenza;
    }
    
    public String getAeroportoArrivo() {
        return aeroportoArrivo;
    }

    public Date getOrario() {
        return orario;
    }

    public Long getCodiceAereo() {
        return codiceAereo;
    }

    public double getPrezzo() {
        return prezzo;
    }
    
    public void setAeroportoArrivo(String aeroportoA) {
        this.aeroportoArrivo = aeroportoA;
    }
    
    public void setAeroportoPartenza(String aeroportoP) {
        this.aeroportoPartenza = aeroportoP;
    }

    public void setOrario(Date orario) {
        this.orario = orario;
    }
    

    public void setCodiceAereo(Long codiceAereo) {
        this.codiceAereo = codiceAereo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

	public int getPostiDisp() {
		return postiDisp;
	}

	public void setPostiDisp(int postiDisp) {
		this.postiDisp = postiDisp;
	}

	public void setCodiceVolo(Long codiceVolo) {
		this.codiceVolo = codiceVolo;
	}
}