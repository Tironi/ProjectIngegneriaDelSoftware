package com.pack.aeroporto.controller;

import com.pack.aeroporto.entity.*;
import com.pack.aeroporto.repository.IAereoRepository;
import com.pack.aeroporto.repository.IOperatoreRepository;
import com.pack.aeroporto.repository.IVoloRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OperatoreController {

    private IOperatoreRepository operatoreRepo;
    private IAereoRepository aereoRepo;
    private IVoloRepository voloRepo;
    
    OperatoreController(IOperatoreRepository operatoreRepo, IAereoRepository aereoRepo, IVoloRepository voloRepo){
    	this.operatoreRepo = operatoreRepo;
    	this.aereoRepo = aereoRepo;
    	this.voloRepo = voloRepo;
    }
    
    @GetMapping("/login")   //nella pagina localhost:8080 verrà eseguito index()
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
    
    @GetMapping("/inserisciVolo")
    public String getInserisciVolo(Model model) {
    	
    	model.addAttribute("volo", new Volo());   
    	model.addAttribute("aerei", aereoRepo.findAll());
    	
    	return "/operatore/inserisciVolo";
    }
    
    @GetMapping("/operatore/menu")
    public String getVisualizzaMenu(Model model) {
    	
    	return "/operatore/menu";
    }
    
    @GetMapping("/visualizzaVoli")
    public String getVisualizzaVolo(Model model) {
    	
    	model.addAttribute("voli", voloRepo.findAll());
    	
    	return "/operatore/visualizzaVoli";
    }
    
    @PostMapping("/operatore/inserisciVolo")
    public String postInserisciVolo(@ModelAttribute Volo volo, Model model) {
		
    	model.addAttribute("volo", volo);
    	Volo result = voloRepo.save(volo);
    	
    	if(result != null) {
            return "operatore/menu";
    	}else {
        	model.addAttribute("Errore", "Non è stato possibile inserire il volo");
            return "error";
    	}
    }
}