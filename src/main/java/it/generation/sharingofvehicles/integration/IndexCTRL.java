package it.generation.sharingofvehicles.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.generation.sharingofvehicles.entities.Utente;
import it.generation.sharingofvehicles.service.PrenotazioneService;
import it.generation.sharingofvehicles.service.UtenteService;
import it.generation.sharingofvehicles.service.VeicoloService;

@Controller
public class IndexCTRL {

	@Autowired
	private UtenteService us;
	@Autowired
	private VeicoloService vs;
	@Autowired
	private PrenotazioneService ps;
	
	
@GetMapping("/")
public ModelAndView getIndex(Model m) {
	
	m.addAttribute("veicoli",vs.findAllVeicoli());
	
	System.out.println("sono in index");
	return  new ModelAndView("home");
}


@GetMapping("login")
public ModelAndView login(Model m) {
	return new ModelAndView("login");
}


@GetMapping("/dashboard")
public ModelAndView login2(Model m) {
	
	System.out.println("sono in get");
	
	return new ModelAndView("login");
}

@PostMapping("/dashboard")
public ModelAndView enterDashboard(Model m, 
		@RequestParam String email
		) {
	
	Utente u = us.findUserByEmail(email);
	
	if(u != null) {
		
		switch (u.getTipo()) {
		
		case "A":
			m.addAttribute("utenti", us.findAllUsers());
			m.addAttribute("veicoli" , vs.findAllVeicoli());
			m.addAttribute("prenotazioni",ps.findAllPrenotazione());
			m.addAttribute("admin", u);
			return new ModelAndView("dashboard");
			
		case "B":

			return this.getIndex(m);
			
		
		default:
			return new ModelAndView("registrazione");
			
		}
	}
		else {
			return new ModelAndView("registrazione");
		}
		
//	return new ModelAndView("dashboard");
}

@PostMapping("/dashboard/insert")
	public ModelAndView insertCliente(Model m,
			@RequestParam String username,
			@RequestParam String email,
			@RequestParam String nome,
			@RequestParam String cognome,
			@RequestParam String nascita,
			@RequestParam String tipo,
			@RequestParam String emailAdmin
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
		
		return this.enterDashboard(m, emailAdmin);
		
		

	}
	



}
