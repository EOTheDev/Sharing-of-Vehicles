package it.generation.sharingofvehicles.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.generation.sharingofvehicles.entities.Utente;
import it.generation.sharingofvehicles.service.UtenteService;

@RestController
@RequestMapping("/api/utente")
public class UtenteCTRL {
	
	@Autowired
	private UtenteService us;
	
	@GetMapping("/all")
	List<Utente> All() {
		return us.findAllUsers();
	}
	
}
