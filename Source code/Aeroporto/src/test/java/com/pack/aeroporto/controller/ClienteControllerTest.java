package com.pack.aeroporto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyLong;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pack.aeroporto.entity.Aereo;
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

	@Mock
	IClienteRepository clienteRepo; 

	@Mock
	IPrenotazioneRepository prenotazioneRepo; 
	
	@Mock
	IAereoRepository aereoRepo;
	
    ClienteController c;
    
	@Mock
	Model m;

    @BeforeEach
    public void init() {
        c = new ClienteController(voloRepo, clienteRepo, prenotazioneRepo, aereoRepo);
	}
	
	@Test
	public void effettuaPrenotazioneTest_tornaTemplate() {
		
		when(voloRepo.findAll()).thenReturn(Arrays.asList(new Volo(new Long(1), "A", "B", new Date(2323223232L), new Long(11), 3.0, 10)));
		when(aereoRepo.findByCodiceAereo(anyLong())).thenReturn(new Aereo(new Long(11), 3));
		
		String result = c.effettuaPrenotazione(m);
		
		assertEquals(result, "/cliente/effettuaPrenotazione");
	}
	
	@Test
	public void effettuaPrenotazioneTest_removeVolo() {
		
		when(voloRepo.findAll()).thenReturn(Arrays.asList(new Volo(new Long(1), "A", "B", new Date(2323223232L), new Long(11), 3.0, 10)));
		when(aereoRepo.findByCodiceAereo(anyLong())).thenReturn(new Aereo(new Long(11), 0));
		
		Volo v = new Volo();
		v.setCodiceVolo(new Long(2));
		v.setCodiceAereo(new Long(1));
		voloRepo.save(v);
		
		String result = c.effettuaPrenotazione(m);
		
		assertEquals(result, "/cliente/error");
	}
	
	@Test
	public void effettuaPrenotazioneTest_nessunVolo() {

		when(voloRepo.findAll()).thenReturn(Arrays.asList());
		Volo v = new Volo();
		v.setCodiceVolo(new Long(2));
		v.setCodiceAereo(new Long(1));
		voloRepo.save(v);
		
		String result = c.effettuaPrenotazione(m);
		
		assertEquals(result, "/cliente/error");
	}
	
	@Test
	public void postEffettuaPrenotazioneTest_esitoAffermativo() {
		
		// cerchiamo se nel repo è presente la prenotazione a CF "tmp123tmp"
		Prenotazione p = new Prenotazione();
		p.setCodiceFiscale("tmp123tmp");
		p.setCodiceVolo(new Long(1));
	
		PrenotazioneDTO pDTO = new PrenotazioneDTO();
		pDTO.setPrenotazione(p);

		Prenotazione inp = new Prenotazione();
		inp.setCodiceFiscale("AAAAAA");
		inp.setCodiceVolo(new Long(10));
		prenotazioneRepo.save(inp);
		
		
		c.postEffettuaPrenotazione(pDTO,  m);
	}
	
	
	
}
