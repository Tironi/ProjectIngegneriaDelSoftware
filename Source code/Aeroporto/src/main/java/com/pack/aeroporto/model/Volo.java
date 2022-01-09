package com.pack.aeroporto.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.time.*;

@Entity
public class Volo {

    private @Id String codice;
    private String aeroporto;
    private LocalDateTime orario;
    private int codiceAereo;
    private double prezzo;

    public String getCodice() {
        return codice;
    }

    public String getAeroporto() {
        return aeroporto;
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
    
    public void setAeroporto(String aeroporto) {
        this.aeroporto = aeroporto;
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