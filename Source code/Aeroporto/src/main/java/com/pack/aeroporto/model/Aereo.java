package com.pack.aeroporto.model;

public class Aereo {
    
    private int codice;
    private int numBagagliCabina;

    public Aereo(int cod, int num) {
    	codice = cod;
    	numBagagliCabina = num;
	}
    
    public int getCodice() {
        return codice;
    }

    public int getNumBagagliCabina() {
        return numBagagliCabina;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setNumBagagliCabina(int numBagagliCabina) {
        this.numBagagliCabina = numBagagliCabina;
    }
    
    
    @Override
    public String toString() {
    	return "Codice Aereo: " + codice + " - Num Bagagli in Cabina : " + numBagagliCabina;
    }
}