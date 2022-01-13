package com.pack.aeroporto.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.common.collect.Lists;
import com.pack.aeroporto.entity.Cliente;
import com.pack.aeroporto.entity.Prenotazione;
import com.pack.aeroporto.entity.Volo;
import com.pack.aeroporto.object.PrenotazioneDTO;
import com.pack.aeroporto.repository.IClienteRepository;
import com.pack.aeroporto.repository.IPrenotazioneRepository;
import com.pack.aeroporto.repository.IVoloRepository;

@Controller
public class ClienteController {
	
	IVoloRepository voloRepo; 
	IClienteRepository clienteRepo; 
	IPrenotazioneRepository prenotazioneRepo; 
	
	ClienteController(IVoloRepository voloRepository, IClienteRepository clienteRepository, IPrenotazioneRepository prenotazioneRepository){
		this.voloRepo = voloRepository;
		this.clienteRepo = clienteRepository;
		this.prenotazioneRepo = prenotazioneRepository;
	}
	
    @GetMapping("/cliente")
    public String index(Model model) {
    	
    	return "/cliente/menu";
    }
    
    @GetMapping("effettuaPrenotazione")
    public String effettuaPrenotazione(Model model) {
    	
    	PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
    	
    	List<Volo> result = Lists.newArrayList(voloRepo.findAll());
    	
    	model.addAttribute("prenotazioneDTO", prenotazioneDTO);
    	model.addAttribute("voli", voloRepo.findAll());
    	
    	return "/cliente/effettuaPrenotazione";
    }
    
    @PostMapping("/cliente/effettuaPrenotazione")
    public String postEffettuaPrenotazione(@ModelAttribute PrenotazioneDTO prenotazioneDTO, Model model) {
    	
    	Cliente clienteResult = prenotazioneDTO.getCliente();
    	Prenotazione prenotazioneResult = prenotazioneDTO.getPrenotazione();
    	
    	Optional<Cliente> cliente = clienteRepo.findById(clienteResult.getCodiceFiscale());
    	
    	//se il cliente non è ancora presente nel db
    	if(cliente == null) {
    		//salvataggio del cliente
    		
    		Cliente input = new Cliente();
    		input.setCodiceFiscale(clienteResult.getCodiceFiscale());
    		clienteRepo.save(input);
    	}
    	
    	//salvataggio prenotazione
    	
    	Prenotazione input = new Prenotazione();
    	input.setCodiceFiscale(clienteResult.getCodiceFiscale());
    	input.setCodiceVolo(prenotazioneResult.getCodiceVolo());
    	prenotazioneRepo.save(input);
    	
    	model.addAttribute("esito", true);
    	return "/cliente/esitoPrenotazione";
    }
    
    @GetMapping("/controlloStorico")
    public String controlloStorico(Model model) {
    	model.addAttribute(new Prenotazione());
    	model.addAttribute("cerca", true);
    	return "/cliente/controlloStorico";
    }
    
    @PostMapping("/cliente/controlloStorico")
    public String mostraStorico(@ModelAttribute Prenotazione prenotazione, Model model) {
    	model.addAttribute("prenotazione", prenotazione);
	
    	//prendiamo tutte le prenotazioni effettuate con il CF inserito
    	List<PrenotazioneDTO> prenotazioneDTO = new ArrayList<PrenotazioneDTO>(); 
    	
    	for (Prenotazione result : prenotazioneRepo.findAllByCodiceFiscale(prenotazione.getCodiceFiscale())) {
			PrenotazioneDTO tmp = new PrenotazioneDTO();
			tmp.setCliente(clienteRepo.findByCodiceFiscale(prenotazione.getCodiceFiscale()));
			tmp.setPrenotazione(result);
			prenotazioneDTO.add(tmp);
		}
    	
    	if(!prenotazioneDTO.isEmpty()) {
    		model.addAttribute("prenotazioneDTO", prenotazioneDTO);
    		model.addAttribute("cerca", false);
    		return "/cliente/controlloStorico";
    	}
    	else {
    		model.addAttribute("status", "Non hai effettuato prenotazioni");
    		return "/cliente/error";
    	}


    }
    
    @PostMapping("controlloStorico")
    public String controlloStorico(@ModelAttribute Prenotazione prenotazione, Model model) {
    	model.addAttribute(new PrenotazioneDTO());
    	PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
    	    	
    	return "/cliente/controlloStorico";
    }
    
    
}
