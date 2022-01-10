package com.pack.aeroporto.object;

import java.util.ArrayList;
import java.util.List;

import com.pack.aeroporto.entity.Volo;


public class PrenotazioneDTO {

	private String codiceFiscale;
	private String nome;
    private String cognome;
    private String codiceVolo;
    private List voli;
    private List compagniaAmici;
    
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    
	public String getCodiceVolo() {
		return codiceVolo;
	}

	public void setCodiceVolo(String codiceVolo) {
		this.codiceVolo = codiceVolo;
	}

	public List getVoli() {
		return voli;
	}

	public void setVoli(List voli) {
		this.voli = voli;
	}
}
