package com.pack.aeroporto.controller;

import com.pack.aeroporto.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AereoController {

    @GetMapping("/")   //nella pagina localhost:8080 verrà eseguito index()
    public String index(Model model) {
    	Aereo ryn = new Aereo(123, 150);
    	model.addAttribute("codiceAereo", ryn.toString());
        return "index";
    }
    
    @GetMapping("/login")   //nella pagina localhost:8080 verrà eseguito index()
    public String login(Model model) {
    	model.addAttribute("op1", new Operatore());
    	return "login";
    }
    
    @PostMapping("/login")
    public String faiLogin(@ModelAttribute Operatore op1, Model model) {
    	model.addAttribute("op1", op1);
    	return "result";
    }
}