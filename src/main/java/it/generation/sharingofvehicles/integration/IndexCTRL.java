package it.generation.sharingofvehicles.integration;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
//	System.out.println("sono in index");
	return  new ModelAndView("home");
}




//login per dashboard
@GetMapping("login")
public ModelAndView login(Model m) {
	return new ModelAndView("login");
}


@GetMapping("/dashboard")
public ModelAndView errorDashboard(Model m) {
	
	System.out.println("sono in get");
	
	return new ModelAndView("errore");
}





//rimandano a dashboard

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
}
		
//	return new ModelAndView("dashboard");


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
	
	
	LocalDate time = LocalDate.now();
	u.setDataIscrizione(time);
	us.addUser(u);
	
	return this.enterDashboard(m, emailAdmin);
	
	

}


@PostMapping("/dashboard/delete")
public ModelAndView deleteCliente(
		@RequestParam int id,
		@RequestParam String emailAdmin,
		Model m) {
	
	System.out.println("sono in delete");
	
	us.deleteUserById(id);
	
	m.addAttribute("utenti",us.findAllUsers());
	
	return this.enterDashboard(m, emailAdmin);
	
}


@PostMapping("/dashboard/update")
	public ModelAndView updateCliente(Model m,
			@RequestParam int id,
			@RequestParam String emailAdmin
			) {
		
		Utente utente = us.findUserById(id);
		
		
	
//		Utente u = new Utente();
//		u.setUsername(username);
//		u.setEmail(email);
//		u.setNome(nome);
//		u.setCognome(cognome);
//		u.setNascita(nascita);
//		u.setTipo(tipo);
		
		
//		us.addUser(u);
		
		return this.enterDashboard(m, emailAdmin);
		
		

}

}
	