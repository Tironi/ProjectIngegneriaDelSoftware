package com.pack.aeroporto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AeroportoController {

	AeroportoController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/index")
    public String index(Model model) {
    	
    	return "/index";
    }
	
}
