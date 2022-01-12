package com.pack.aeroporto.object;

import java.util.List;

import com.pack.aeroporto.entity.Cliente;
import com.pack.aeroporto.entity.Prenotazione;

public class PrenotazioneDTO {

	private Prenotazione prenotazione;
	private Cliente cliente;
    private List compagniaAmici;
    
   	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

	public List getCompagniaAmici() {
		return compagniaAmici;
	}

	public void setCompagniaAmici(List compagniaAmici) {
		this.compagniaAmici = compagniaAmici;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
