package com.pack.aeroporto.object;

import java.util.List;

import com.pack.aeroporto.entity.Cliente;
import com.pack.aeroporto.entity.Prenotazione;

public class PrenotazioneDTO {

  
    private Cliente cliente;
    private Prenotazione prenotazione;
    
    private String codiceVolo;
    
    private List compagniaAmici;
    
    public PrenotazioneDTO(){
    	cliente = new Cliente();
    	prenotazione = new Prenotazione();
    }

	public String getCodiceVolo() {
		return codiceVolo;
	}

	public void setCompagniaAmici(List compagniaAmici) {
		this.compagniaAmici = compagniaAmici;
	}

	public List getCompagniaAmici() {
		return compagniaAmici;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}
        
}
