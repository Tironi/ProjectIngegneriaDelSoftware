package com.pack.aeroporto.object;

import java.util.List;

import com.pack.aeroporto.entity.Cliente;
import com.pack.aeroporto.entity.Prenotazione;

public class PrenotazioneDTO {

  
    private Cliente cliente;
    private Prenotazione prenotazione;
    
    private Long codiceVolo;
    
    private List compagniaAmici;
    
    private boolean valigiaCabina;
    
    public PrenotazioneDTO(){
    	cliente = new Cliente();
    	prenotazione = new Prenotazione();
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


	public Long getCodiceVolo() {
		return codiceVolo;
	}

	public void setCodiceVolo(Long codiceVolo) {
		this.codiceVolo = codiceVolo;
	}

	public boolean getValigiaCabina() {
		return valigiaCabina;
	}

	public void setValigiaCabina(boolean valigiaCabina) {
		this.valigiaCabina = valigiaCabina;
	}
        
}
