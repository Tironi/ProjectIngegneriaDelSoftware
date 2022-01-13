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

    private @Id @GeneratedValue Long codice;
    private String aeroportoPartenza;
    private String aeroportoArrivo;

    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date orario;
    private long codiceAereo;
    private double prezzo;

    public Long getCodice() {
        return codice;
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
    

    public long getCodiceAereo() {
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
    

    public void setCodiceAereo(long codiceAereo) {
        this.codiceAereo = codiceAereo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}