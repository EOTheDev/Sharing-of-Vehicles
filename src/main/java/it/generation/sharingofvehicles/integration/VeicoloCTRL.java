package it.generation.sharingofvehicles.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import it.generation.sharingofvehicles.entities.Veicolo;
import it.generation.sharingofvehicles.service.VeicoloService;
import it.generation.sharingofvehicles.service.UtenteService;
import it.generation.sharingofvehicles.service.PrenotazioneService;

@RestController
@RequestMapping("/veicolo")
public class VeicoloCTRL {
	@Autowired 
	private VeicoloService vs;
	@Autowired
	private UtenteService us;
	@Autowired
	private PrenotazioneService ps;
	
	
	
	@GetMapping("")
	public ModelAndView login(Model m) {
		return new ModelAndView("singoloVeicolo");
	}
	
	@GetMapping("/{id}")
	public ModelAndView viewAutomobile(Model m, @PathVariable("id") int id) {
		
		m.addAttribute("veicolo", vs.findVeicoloById(id));
		
		return new ModelAndView("singoloVeicolo");
	}
	

	
	
}
