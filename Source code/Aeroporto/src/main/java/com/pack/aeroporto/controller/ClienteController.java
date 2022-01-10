package com.pack.aeroporto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pack.aeroporto.object.PrenotazioneDTO;

@Controller
public class ClienteController {
	
	ClienteController(){
		
	}
	
    @GetMapping("/cliente")
    public String index(Model model) {
    	
    	return "/cliente/menu";
    }
    
    @GetMapping("effettuaPrenotazione")
    public String effettuaPrenotazione(Model model) {
    	
    	model.addAttribute("prenotazioneDTO", new PrenotazioneDTO());
    	
    	return "/cliente/effettuaPrenotazione";
    }
    
    
}
