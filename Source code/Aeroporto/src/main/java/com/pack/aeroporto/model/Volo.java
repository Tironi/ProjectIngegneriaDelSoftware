package com.pack.aeroporto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.*;

@Entity
public class Volo {

    private @Id @GeneratedValue Long codice;
    private String aeroportoPartenza;
    private String aeroportoArrivo;
    private LocalDateTime orario;
    private int codiceAereo;
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

    public LocalDateTime getOrario() {
        return orario;
    }

    public int getCodiceAereo() {
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

    public void setOrario(LocalDateTime orario) {
        this.orario = orario;
    }

    public void setCodiceAereo(int codiceAereo) {
        this.codiceAereo = codiceAereo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}