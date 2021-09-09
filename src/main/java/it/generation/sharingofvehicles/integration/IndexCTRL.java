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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.generation.sharingofvehicles.entities.Prenotazione;
import it.generation.sharingofvehicles.entities.Utente;
import it.generation.sharingofvehicles.entities.Veicolo;
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

@GetMapping("/registrazione")
public ModelAndView registrazione(Model m) {
	return new ModelAndView("registrazione");
}


@GetMapping("/dashboard")
public ModelAndView errorDashboard(Model m) {
	
	System.out.println("sono in get");
	
	return new ModelAndView("errore");
}



@GetMapping("/dashboard/{id}")
public ModelAndView enterByUtente(Model m, @PathVariable("id") int id) {
	Utente utente= us.findUserById(id);
	return enterDashboard(m, utente.getEmail());
}



//rimandano a dashboard

@PostMapping("/dashboard")
public ModelAndView enterDashboard(Model m, 
		@RequestParam String email
		) {
	
	Utente utente = us.findUserByEmail(email);
	
	if(utente != null) {
		
		switch (utente.getTipo()) {
		
		case "A":
			//m.addAttribute("admin", u); //admin
			//System.out.println(u);
			m.addAttribute("listaUtenti", us.findAllUsers());
			m.addAttribute("veicoli" , vs.findAllVeicoli());
			m.addAttribute("prenotazioni", ps.findAllPrenotazione());
			//u=new Utente();
			m.addAttribute("utente", utente);
			return new ModelAndView("dashboard");
			// return "dashboard";
		case "B":
			m.addAttribute("utente", utente);
			m.addAttribute("prenotazioni", ps.findPrenotazioneByUtenteId(utente.getId()));
			// return "redirect:/";
			return this.getIndex(m);
			
		
		default:
			// return "registrazione";
			return new ModelAndView("registrazione");
			
		}
	}
		else {

			// return "registrazione";
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
public String deleteCliente(
		@RequestParam int id,
		@RequestParam String emailAdmin,
		Model m) {

	us.deleteUserById(id);
	return "redirect:/dashboard/"+us.findUserByEmail(emailAdmin).getId();
	
}


@PostMapping("/dashboard/updateCliente")
	public String updateCliente(Model m,
	@RequestParam int id,
	@RequestParam String username,
	@RequestParam String email,
	@RequestParam String nome,
	@RequestParam String cognome,
	@RequestParam String nascita,
	@RequestParam String tipo,
	@RequestParam int utenteId
			) {
		
		Utente utente = us.findUserById(id);

		utente.setUsername(username);
		utente.setEmail(email);
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setNascita(nascita);
		utente.setTipo(tipo);
		us.addUser(utente);
		
		return "redirect:/dashboard/"+utenteId;
		
		

}
@PostMapping("/updCliente")
public String updClienteHome(Model m,
@RequestParam String username,
@RequestParam String email,
@RequestParam String nome,
@RequestParam String cognome,
@RequestParam String nascita,
//@RequestParam String tipo,
@RequestParam int utenteId
		) {
	
	Utente utente = us.findUserById(utenteId);

	utente.setUsername(username);
	utente.setEmail(email);
	utente.setNome(nome);
	utente.setCognome(cognome);
	utente.setNascita(nascita);
	utente.setTipo("B");
	us.addUser(utente);
	
	return "redirect:/dashboard/"+utenteId;
	
	

}
@PostMapping("/dashboard/updatePrenotazione")
	public String updatePrenotazione(Model m,
	@RequestParam int id,
	@RequestParam String email,
	@RequestParam String dataPrenotazione,
	@RequestParam int utenteId
			) {
		
		Prenotazione pren = ps.findPrenotazioneById(id);

		pren.setUtenteId(us.findUserByEmail(email));
		pren.setVeicoloId(vs.findVeicoloById(id));
		
		// prendo la data come stringa e la trasformo in un array di int per creare la data
		int[] data= new int[3];
		String[] dataStrArr=dataPrenotazione.split("-");
		for (int i = 0; i < data.length; i++) {
			data[i]= Integer.parseInt(dataStrArr[i]);
		
		}
		pren.setDataPrenotazione(LocalDate.of(data[0], data[1], data[2]));
		
		ps.addPrenotazione(pren);
		return "redirect:/dashboard/"+utenteId;
		
		

}
@PostMapping("/dashboard/removePrenotazione")
		public String removePrenotazione(Model m,
				@RequestParam("prenotazioneId") int id,
				@RequestParam("utenteId") int utenteId

				){
					ps.deletePrenotazioneById(id);

					return "redirect:/dashboard/"+utenteId; 	
				}
		
		



@PostMapping("insertUser")
public ModelAndView insertUser(Model m,
		@RequestParam String username,
		@RequestParam String email,
		@RequestParam String nome,
		@RequestParam String cognome,
		@RequestParam String nascita,
		@RequestParam String password
		) {
	
	Utente u = new Utente();
	u.setUsername(username);
	u.setEmail(email);
	u.setNome(nome);
	u.setCognome(cognome);
	u.setNascita(nascita);
	u.setTipo("B");
	u.setPassword(password);
	
	
	LocalDate time = LocalDate.now();
	u.setDataIscrizione(time);
	us.addUser(u);
	//loggedUser
	return this.enterDashboard(m, email);
	

}


@PostMapping("/dashboard/addVeicolo")
public String addVeicolo(Model m,
		Veicolo veicolo,
		@RequestParam("imgUpl") MultipartFile multipartFile
		//,
		//RedirectAttributes redirectAttributes
		) {
			
			Veicolo veicoloSalvato = new Veicolo(); // vuoto
			veicoloSalvato.setLatitudine(45.062943674698175);
			veicoloSalvato.setLongitudine(7.679208331070612);
		
			//2
			if(multipartFile == null || multipartFile.isEmpty()) {
				//3
				veicoloSalvato = vs.addVeicolo(veicolo);
				
			}else {
				//4
				veicoloSalvato = vs.addVeicolo(veicolo, multipartFile);			
			}
			
			//5
			//redirectAttributes.addFlashAttribute("utente", veicoloSalvato.getUtenteId());
			
			return "redirect:/dashboard/"+veicoloSalvato.getUtenteId().getId(); 
	
	
			
		}
		@PostMapping("/dashboard/updVeicolo")
		public String updVeicolo(Model m,
				Veicolo veicolo,
				@RequestParam("imgUpl") MultipartFile multipartFile,
				@RequestParam("utenteId") int utenteId
				) {
		
					Veicolo veicoloNuovo=vs.findVeicoloById(veicolo.getId());
					veicoloNuovo.setTipologia(veicolo.getTipologia());
					veicoloNuovo.setAlimentazione(veicolo.getAlimentazione());
					veicoloNuovo.setModello(veicolo.getModello());
					veicoloNuovo.setColore(veicolo.getColore());
					veicoloNuovo.setDescrizione(veicolo.getDescrizione());
					veicoloNuovo.setIndirizzo(veicolo.getIndirizzo());
					veicoloNuovo.setLatitudine( 12
						//per ora vuoto veicolo.getLatitudine()
						);
					veicoloNuovo.setLongitudine( 12
						//per ora vuoto veicolo.getLatitudine()
						);
					veicoloNuovo.setPrezzo(veicolo.getPrezzo());
					veicoloNuovo.setRuote(veicolo.getRuote());
					veicoloNuovo.setPesoCo2(veicolo.getPesoCo2());
					//non aggiorniamo l'utente creatore

				
					if(multipartFile == null || multipartFile.isEmpty()) {
						//salvo senza img
						veicolo.setImmagine(veicoloNuovo.getImmagine());
						veicolo = vs.addVeicolo(veicoloNuovo);
					} else {
						//salvo con img
						veicolo = vs.addVeicolo(veicoloNuovo, multipartFile);			
					}
					
					
					//5
					//redirectAttributes.addFlashAttribute("utente", veicoloSalvato.getUtenteId());
					
					return "redirect:/dashboard/"+utenteId; 
			
			
					
				}



		@PostMapping("/dashboard/removeVeicolo")
		public String removeVeicolo(Model m,
				@RequestParam("veicoloId") int id,
				@RequestParam("utenteId") int utenteId

				){
					vs.deleteVeicoloById(id);

					return "redirect:/dashboard/"+utenteId; 	
				}
		
		
		
		}
