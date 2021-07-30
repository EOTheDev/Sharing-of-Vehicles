
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
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import it.generation.sharingofvehicles.entities.Utente;
import it.generation.sharingofvehicles.service.PrenotazioneService;
import it.generation.sharingofvehicles.service.UtenteService;
import it.generation.sharingofvehicles.service.VeicoloService;

@RestController
@RequestMapping("/dashboard")
public class UtenteCTRL {
	
	@Autowired
	private UtenteService us;
	@Autowired
	private VeicoloService vs;
	@Autowired
	private PrenotazioneService ps;
	
	@PostMapping("/insert")
	public String insertCliente(
			@RequestParam String username,
			@RequestParam String email,
			@RequestParam String nome,
			@RequestParam String cognome,
			@RequestParam String nascita,
			@RequestParam String tipo
			) {
		
		Utente u = new Utente();
		u.setUsername(username);
		u.setEmail(email);
		u.setNome(nome);
		u.setCognome(cognome);
		u.setNascita(nascita);
		u.setTipo(tipo);
		u.setPassword("ciao15");
		
		us.addUser(u);
		
		return "dashboard";
		
		

	}
	

}
