package com.pack.aeroporto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;
import com.pack.aeroporto.entity.Operatore;
import com.pack.aeroporto.repository.IAereoRepository;
import com.pack.aeroporto.repository.IOperatoreRepository;
import com.pack.aeroporto.repository.IVoloRepository;

public class OperatoreControllerTest {
	
	@Mock
	IOperatoreRepository operatoreRepo;

	@Mock
	IAereoRepository aereoRepo; 

	@Mock
	IVoloRepository voloRepo; 
	
	OperatoreController c;
    
	@Mock
	Model modelModel;

	@Mock
	Model operatoreModel;
	
    @BeforeEach
    public void init() {
        c = new OperatoreController(operatoreRepo, aereoRepo, voloRepo);
	}
	
	@Test
	public void afterFaiLoginTest_accessoEseguito() {
		//when(operatoreRepo.findByEmail(anyString())).thenReturn(new Operatore("EMAIL", "PASSWORD"));
		
		Operatore p = new Operatore();
		p.setCodiceFiscale("CODICEFISCALE");
		p.setNome("NOME");
		p.setCognome("COGNOME");
		p.setEmail("EMAIL");
		p.setPSW("PASSWORD");
		
		String result = c.faiLogin(p, modelModel);
	}
}
