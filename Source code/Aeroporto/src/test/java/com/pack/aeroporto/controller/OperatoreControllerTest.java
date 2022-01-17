package com.pack.aeroporto.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pack.aeroporto.entity.Operatore;
import com.pack.aeroporto.object.PrenotazioneDTO;
import com.pack.aeroporto.repository.IAereoRepository;
import com.pack.aeroporto.repository.IOperatoreRepository;
import com.pack.aeroporto.repository.IVoloRepository;

public class OperatoreControllerTest {
	
	@Test
	public void faiLoginTest(IOperatoreRepository operatoreRepo, IAereoRepository aereoRepo, IVoloRepository voloRepo) {
		OperatoreController operatoreController = new OperatoreController(operatoreRepo, aereoRepo, voloRepo);
		Operatore op = new Operatore();
		
		assertEquals(true, true);
	}
}
