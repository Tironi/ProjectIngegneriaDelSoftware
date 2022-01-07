package com.pack.aeroporto.model;

import java.time.*;

public class Volo {

    private String codice;
    private String aeroporto;
    private LocalDateTime orario;
    private int codiceAereo;
    private double prezzo;
    private Aereo viaggiaSuAereo;
    private Operatore inseritoDa;

    private String getCodice() {
        return codice;
    }

    private String getAeroporto() {
        return aeroporto;
    }

    private LocalDateTime getOrario() {
        return orario;
    }

    private int getCodiceAereo() {
        return codiceAereo;
    }

    private double getPrezzo() {
        return prezzo;
    }
    
    public Aereo getViaggiaSuAereo() {
        return viaggiaSuAereo;
    }

    public Operatore getInseritoDa() {
        return inseritoDa;
    }

    private void setAeroporto(String aeroporto) {
        this.aeroporto = aeroporto;
    }

    private void setOrario(LocalDateTime orario) {
        this.orario = orario;
    }

    private void setCodiceAereo(int codiceAereo) {
        this.codiceAereo = codiceAereo;
    }

    private void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setViaggiaSuAereo(Aereo viaggiaSuAereo) {
        this.viaggiaSuAereo = viaggiaSuAereo;
    }

    public void setInseritoDa(Operatore inseritoDa) {
        this.inseritoDa = inseritoDa;
    }

   
    public int getPostiSedereDisp() {
    	return 0;
    }
    public int getNumBagCabinaDisp() {
    	return 0;
    }
}