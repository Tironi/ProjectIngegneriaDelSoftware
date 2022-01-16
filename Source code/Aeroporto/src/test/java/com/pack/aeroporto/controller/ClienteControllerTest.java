package com.pack.aeroporto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pack.aeroporto.entity.Prenotazione;
import com.pack.aeroporto.entity.Volo;
import com.pack.aeroporto.object.PrenotazioneDTO;
import com.pack.aeroporto.repository.IAereoRepository;
import com.pack.aeroporto.repository.IClienteRepository;
import com.pack.aeroporto.repository.IPrenotazioneRepository;
import com.pack.aeroporto.repository.IVoloRepository;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

	@Mock
	IVoloRepository voloRepo;
	IClienteRepository clienteRepo; 
	IPrenotazioneRepository prenotazioneRepo; 
	IAereoRepository aereoRepo;
	
	Model m;

	
	@Test
	public void effettuaPrenotazioneTest() {
		
		ClienteController c = new ClienteController(voloRepo, clienteRepo, prenotazioneRepo, aereoRepo);
		
		Volo v = new Volo();
		v.setCodiceAereo(new Long(101));
		voloRepo.save(v);
		
		c.effettuaPrenotazione(m);
	}
	
	@Test
	public void postEffettuaPrenotazioneTest() {
		ClienteController c = new ClienteController(voloRepo, clienteRepo, prenotazioneRepo, aereoRepo);
		
		// cerchiamo se nel repo è presente la prenotazione a CF "tmp123tmp"
		Prenotazione p = new Prenotazione();
		p.setCodiceFiscale("tmp123tmp");
		p.setCodiceVolo(new Long(10));
	
		PrenotazioneDTO pDTO = new PrenotazioneDTO();
		pDTO.setPrenotazione(p);

		Prenotazione inp = new Prenotazione();
		inp.setCodiceFiscale("AAAAAA");
		inp.setCodiceVolo(new Long(10));
		prenotazioneRepo.save(inp);
		
		
		c.postEffettuaPrenotazione(pDTO,  m);
	}
	
	
	
}
