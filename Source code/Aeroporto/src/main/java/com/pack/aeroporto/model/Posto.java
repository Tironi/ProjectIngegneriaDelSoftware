package com.pack.aeroporto.model;

import java.util.*;
import java.time.*;

public class Posto {
	
    private int numero;
    private boolean prenotato;
    private int codiceAereo;
    private Aereo contiene;

    private int getNumero() {
        return numero;
    }

    private boolean isPrenotato() {
        return prenotato;
    }

    private int getCodiceAereo() {
        return codiceAereo;
    }

    public Aereo getContiene() {
        return contiene;
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }

    private void setPrenotato(boolean prenotato) {
        this.prenotato = prenotato;
    }

    private void setCodiceAereo(int codiceAereo) {
        this.codiceAereo = codiceAereo;
    }

    public void setContiene(Aereo contiene) {
        this.contiene = contiene;
    }

}