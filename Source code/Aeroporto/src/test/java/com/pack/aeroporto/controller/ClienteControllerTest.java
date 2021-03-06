package com.pack.aeroporto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pack.aeroporto.entity.Aereo;
import com.pack.aeroporto.entity.Cliente;
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
	Model modelModel;

	@Mock
	Cliente clienteModel;

    @BeforeEach
    public void init() {
        c = new ClienteController(voloRepo, clienteRepo, prenotazioneRepo, aereoRepo);
	}
	
	@Test
	public void afterEffettuaPrenotazioneTest_tornaTemplate() {
		
		when(voloRepo.findAll()).thenReturn(Arrays.asList(new Volo(new Long(1), "A", "B", new Date(2323223232L), new Long(11), 3.0, 10)));
		when(aereoRepo.findByCodiceAereo(anyLong())).thenReturn(new Aereo(new Long(11), 3));
		
		clienteModel = new Cliente("abelo", "alessandro", "belotti", "alebelo@gmail", "123");
		String result = c.effettuaPrenotazione(modelModel, clienteModel);
		
		assertEquals(result, "/cliente/effettuaPrenotazione");
	}
	
	@Test
	public void afterEffettuaPrenotazioneTest_removeVolo() {
		
		when(voloRepo.findAll()).thenReturn(Arrays.asList(new Volo(new Long(1), "A", "B", new Date(2323223232L), new Long(11), 3.0, 10)));
		when(aereoRepo.findByCodiceAereo(anyLong())).thenReturn(new Aereo(new Long(11), 0));
		
		Volo v = new Volo(); 
		v.setCodiceVolo(new Long(2));
		v.setCodiceAereo(new Long(1));
		voloRepo.save(v);

		clienteModel = new Cliente("abelo", "alessandro", "belotti", "alebelo@gmail", "123");
		String result = c.effettuaPrenotazione(modelModel, clienteModel);
		
		assertEquals(result, "/cliente/error");
	}
	
	@Test
	public void beforeEffettuaPrenotazioneTest_nessunVolo() {

		// non avendo ancora inserito alcun volo il richiamo della effettuaPrenotazione
		// ?? inutile perch?? non sar?? possibile selezionare alcun codiceVolo
		when(voloRepo.findAll()).thenReturn(Arrays.asList());
		
		Volo v = new Volo();
		v.setCodiceVolo(new Long(2));
		v.setCodiceAereo(new Long(1));
		voloRepo.save(v);

		clienteModel = new Cliente("abelo", "alessandro", "belotti", "alebelo@gmail", "123");
		String result = c.effettuaPrenotazione(modelModel, clienteModel);
		
		assertEquals(result, "/cliente/error");
	}
	
	@Test
	public void afterEffettuaPrenotazioneTest_esitoAffermativo() {
		
		when(voloRepo.findByCodiceVolo(anyLong())).thenReturn(new Volo(new Long(1), "A", "B", new Date(2323223232L), new Long(11), 3.0, 10));
		when(aereoRepo.findByCodiceAereo(anyLong())).thenReturn(new Aereo(new Long(11), 10));
		when(clienteRepo.findById(anyString())).thenReturn(Optional.of(new Cliente()));
		
		Prenotazione p = new Prenotazione();
		p.setCodiceFiscale("CODICEFISCALE");
		p.setCodiceVolo(new Long(1));
	
		Cliente cliente = new Cliente();
		cliente.setCodiceFiscale("CODICEFISCALE");
		cliente.setNome("NOME");
		cliente.setCognome("COGNOME");
		
		PrenotazioneDTO pDTO = new PrenotazioneDTO();
		pDTO.setPrenotazione(p);
		pDTO.setCliente(cliente);

		String result = c.postEffettuaPrenotazione(pDTO,  modelModel);

		assertEquals(result, "/cliente/esitoPrenotazione");
	}

	@Test
	public void afterEffettuaPrenotazioneTest_clienteNonPresente() {
		
		when(voloRepo.findByCodiceVolo(anyLong())).thenReturn(new Volo(new Long(1), "A", "B", new Date(2323223232L), new Long(11), 3.0, 10));
		when(aereoRepo.findByCodiceAereo(anyLong())).thenReturn(new Aereo(new Long(11), 10));
		
		Prenotazione p = new Prenotazione();
		p.setCodiceFiscale("CODICEFISCALE");
		p.setCodiceVolo(new Long(1));
	
		Cliente cliente = new Cliente();
		cliente.setCodiceFiscale("CODICEFISCALE");
		cliente.setNome("NOME");
		cliente.setCognome("COGNOME");
		
		PrenotazioneDTO pDTO = new PrenotazioneDTO();
		pDTO.setPrenotazione(p); 
		pDTO.setCliente(cliente);

		String result = c.postEffettuaPrenotazione(pDTO,  modelModel);

		assertEquals(result, "/cliente/esitoPrenotazione");
	}
	
	@Test
	public void afterEffettuaPrenotazioneTest_voloNonPresente() {
		
		Prenotazione p = new Prenotazione();
		p.setCodiceFiscale("CODICEFISCALE");
		p.setCodiceVolo(new Long(1));
	
		Cliente cliente = new Cliente();
		cliente.setCodiceFiscale("CODICEFISCALE");
		cliente.setNome("NOME");
		cliente.setCognome("COGNOME");
		
		PrenotazioneDTO pDTO = new PrenotazioneDTO();
		pDTO.setPrenotazione(p);
		pDTO.setCliente(cliente);

		// viene richiamata la postEffettuaPrenotazione con un codiceVolo non presente nel repo:
		// questo capita se la chiamata viene fatto da un tool esterno (Postman) 
		String result = c.postEffettuaPrenotazione(pDTO,  modelModel);

		assertEquals(result, "/cliente/error");
	}
	
}
