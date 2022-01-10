package com.pack.aeroporto.controller;

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
    	
    	prenotazioneDTO.setVoli(result);
    	
    	model.addAttribute("prenotazioneDTO", prenotazioneDTO);
    	model.addAttribute("voli", voloRepo.findAll());
    	
    	return "/cliente/effettuaPrenotazione";
    }
    
    @PostMapping("/cliente/effettuaPrenotazione")
    public String postEffettuaPrenotazione(@ModelAttribute PrenotazioneDTO prenotazioneDTO, Model model) {
    	
    	Optional<Cliente> cliente = clienteRepo.findById(prenotazioneDTO.getCodiceFiscale());
    	
    	if(cliente == null) {
    		//salvataggio del cliente
    		
    		Cliente input = new Cliente();
    		input.setCodiceFiscale(prenotazioneDTO.getCodiceFiscale());
    		clienteRepo.save(input);
    	}
    	
    	//salvataggio prenotazione
    	
    	Prenotazione input = new Prenotazione();
    	input.setCodiceFiscale(prenotazioneDTO.getCodiceFiscale());
    	input.setCodiceVolo(prenotazioneDTO.getCodiceVolo());
    	prenotazioneRepo.save(input);
    	
    	return "/cliente";
    }
    
    @GetMapping("controlloStorico")
    public String controlloStorico(Model model) {
    	model.addAttribute(new PrenotazioneDTO());
    	return "/cliente/controlloStorico";
    }
}
