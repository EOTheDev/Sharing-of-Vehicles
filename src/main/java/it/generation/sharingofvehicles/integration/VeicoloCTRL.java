package it.generation.sharingofvehicles.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.generation.sharingofvehicles.entities.Veicolo;
import it.generation.sharingofvehicles.service.VeicoloService;

@RestController
@RequestMapping("/api/veicoli")
public class VeicoloCTRL {

	@Autowired
	private VeicoloService vs;
	
	@GetMapping("/all")
	List<Veicolo> all() {
		return vs.findAllVeicoli();
	}
}
