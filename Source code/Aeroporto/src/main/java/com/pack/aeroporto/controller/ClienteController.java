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
import com.pack.aeroporto.entity.Aereo;
import com.pack.aeroporto.entity.Cliente;
import com.pack.aeroporto.entity.Prenotazione;
import com.pack.aeroporto.entity.Volo;
import com.pack.aeroporto.object.PrenotazioneDTO;
import com.pack.aeroporto.repository.IAereoRepository;
import com.pack.aeroporto.repository.IClienteRepository;
import com.pack.aeroporto.repository.IPrenotazioneRepository;
import com.pack.aeroporto.repository.IVoloRepository;

@Controller
public class ClienteController {
	
	IVoloRepository voloRepo; 
	IClienteRepository clienteRepo; 
	IPrenotazioneRepository prenotazioneRepo; 
	IAereoRepository aereoRepo;
	
	ClienteController(IVoloRepository voloRepository, IClienteRepository clienteRepository, IPrenotazioneRepository prenotazioneRepository, IAereoRepository aereoRepository){
		this.voloRepo = voloRepository;
		this.clienteRepo = clienteRepository;
		this.prenotazioneRepo = prenotazioneRepository;
		this.aereoRepo = aereoRepository;
	}
	
	
    @GetMapping("/cliente")
    public String index(Model model) {
    	
    	return "/cliente/menu";
    }
    
    @GetMapping("effettuaPrenotazione")
    public String effettuaPrenotazione(Model model) {
    	
    	PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
    	
    	List<Volo> result = Lists.newArrayList(voloRepo.findAll());
		
    	getVoli(result);
    	
    	if(result.size() == 0) {
    		model.addAttribute("status", "Nessun volo disponibile");
    		return "/cliente/error";
    	}
    	
    	model.addAttribute("prenotazioneDTO", prenotazioneDTO);
    	model.addAttribute("voli", result);
    	
    	return "/cliente/effettuaPrenotazione";
    }

	private void getVoli(List<Volo> result) {
		Iterator t = result.iterator(); 
    	while(t.hasNext()) {
		    Volo v = (Volo) t.next();
		    Aereo a = aereoRepo.findByCodiceAereo(v.getCodiceAereo());
		    List<Prenotazione> p = prenotazioneRepo.findAllByCodiceVolo(v.getCodiceVolo());
  			v.setPostiDisp(a.get_num_bagagli_cabina() - p.size());
  			if(v.getPostiDisp() == 0) {
  				t.remove();
  			}
		}
	}
    
    @PostMapping("/cliente/effettuaPrenotazione")
    public String postEffettuaPrenotazione(@ModelAttribute PrenotazioneDTO prenotazioneDTO, Model model) {
    	
    	Cliente clienteResult = prenotazioneDTO.getCliente();
    	Prenotazione prenotazioneResult = prenotazioneDTO.getPrenotazione();
    	Volo v = voloRepo.findByCodiceVolo(prenotazioneResult.getCodiceVolo());
    	
    	if(v == null) {
        	model.addAttribute("status", "Il volo non esiste");
    		return "/cliente/error";
    	}

    	Aereo a = aereoRepo.findByCodiceAereo(v.getCodiceAereo());
        	
    	Optional<Cliente> cliente = Optional.ofNullable(clienteRepo.findById(clienteResult.getCodiceFiscale()).orElse(null));
    	
    	//se il cliente non è ancora presente nel db
    	if(!cliente.isPresent()) {
    		//salvataggio del cliente
    		
    		Cliente input = new Cliente();
    		input.setCodiceFiscale(clienteResult.getCodiceFiscale());
    		input.setNome(clienteResult.getNome());
    		input.setCognome(clienteResult.getCognome());
    		clienteRepo.save(input);
    	}
    	    	
    	int postiValigieCabinaOccupati = numeroPostiDisponibili(prenotazioneResult);
    	
    	//salvataggio prenotazione
    	
    	Prenotazione input = new Prenotazione();
    	input.setCodiceFiscale(clienteResult.getCodiceFiscale());
    	input.setCodiceVolo(prenotazioneResult.getCodiceVolo());
    	input.setNumPosto(postiValigieCabinaOccupati + 1);
    	input.setValigiaCabina(prenotazioneResult.isValigiaCabina());

    	prenotazioneRepo.save(input);
    	
    	model.addAttribute("esito", true);
    	model.addAttribute("status", "Prenotazione andata a buon fine");
    	
    	return "/cliente/esitoPrenotazione";
    }
    
    private int numeroPostiDisponibili(Prenotazione prenotazioneResult) {
    	//calcolo del numero di posti ancora disponibili
    	
    	List<Prenotazione> p = prenotazioneRepo.findAllByCodiceVolo(prenotazioneResult.getCodiceVolo());
    	
    	int postiValigieCabinaOccupati = 0;    	
    	Iterator t = p.iterator();
    	while(t.hasNext()) {
    		Prenotazione prenotazioneItem = (Prenotazione) t.next();
		    if(prenotazioneItem.isValigiaCabina()) {
    			postiValigieCabinaOccupati +=1;
    		}
		}
    	
    	return postiValigieCabinaOccupati;
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
			
			if(clienteRepo.findByCodiceFiscale(prenotazione.getCodiceFiscale()) == null)
				return "/cliente/error";
			
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
    
}
