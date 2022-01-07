package com.pack.aeroporto.controller;

import com.pack.aeroporto.model.*;
import com.pack.aeroporto.repository.IOperatoreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AereoController {

    private IOperatoreRepository repository;
    
    AereoController(IOperatoreRepository repo){
    	repository = repo;
    }
    
    @GetMapping("/login")   //nella pagina localhost:8080 verrà eseguito index()
    public String login(Model model) {
    	model.addAttribute("op1", new Operatore());
    	return "login";
    }
    
    @PostMapping("/login")
    public String faiLogin(@ModelAttribute Operatore op1, Model model) {
    	model.addAttribute("op1", op1);
    	
    	Operatore result = repository.findByEmail(op1.getEmail());
    	
    	if(result != null) {
        	model.addAttribute("op1", result);
            return "result";
    	}else {
        	model.addAttribute("Errore", "Non è stato possibile trovare l'operatore");
            return "error";
    	}
    }
}