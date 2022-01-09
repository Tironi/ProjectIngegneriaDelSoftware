package com.pack.aeroporto.controller;

import com.pack.aeroporto.model.*;
import com.pack.aeroporto.repository.IAereoRepository;
import com.pack.aeroporto.repository.IOperatoreRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OperatoreController {

    private IOperatoreRepository operatoreRepo;
    private IAereoRepository aereoRepo;
    
    OperatoreController(IOperatoreRepository operatoreRepo, IAereoRepository aereoRepo){
    	this.operatoreRepo = operatoreRepo;
    	this.aereoRepo = aereoRepo;
    }
    
    @GetMapping("/operatore/login")   //nella pagina localhost:8080 verrà eseguito index()
    public String login(Model model) {
    	model.addAttribute("op", new Operatore());
    	return "/operatore/login";
    }
    
    @PostMapping("/operatore/login")
    public String faiLogin(@ModelAttribute Operatore op, Model model) {
    	model.addAttribute("op", op);
    	
    	Operatore result = operatoreRepo.findByEmail(op.getEmail());
    	
    	if(result != null) {
        	model.addAttribute("op", result);
            return "operatore/menu";
    	}else {
        	model.addAttribute("Errore", "Non è stato possibile trovare l'operatore");
            return "error";
    	}
    }
    
    @GetMapping("/operatore/inserisciVolo")
    public String getInserisciVolo(Model model) {
    	
    	model.addAttribute("volo", new Volo());   
    	model.addAttribute("aerei", aereoRepo.findAll());
    	
    	return "/operatore/inserisciVolo";
    }
    
    @PostMapping("/operatore/inserisciVolo")
    public String postInserisciVolo(@ModelAttribute Volo volo, Model model) {
		
    	//Controlla i dati in Volo
    	//Inserire il volo nel database
    	//Torna nel menu
    	
    	return null;
    }
}