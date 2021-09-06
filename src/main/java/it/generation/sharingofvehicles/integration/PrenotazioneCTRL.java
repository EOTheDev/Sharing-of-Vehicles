package it.generation.sharingofvehicles.integration;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import it.generation.sharingofvehicles.entities.Utente;
import it.generation.sharingofvehicles.service.PrenotazioneService;
import it.generation.sharingofvehicles.service.UtenteService;
import it.generation.sharingofvehicles.service.VeicoloService;

@RestController
@RequestMapping("/booking")
public class PrenotazioneCTRL {
	@Autowired 
	private VeicoloService vs;
	@Autowired
	private UtenteService us;
	@Autowired
	private PrenotazioneService ps;
	
	
	
	@GetMapping("")
	public String booking(Model m) {
		return "redirectto:/";
	}
	
	@GetMapping("/data={data}")
	public ModelAndView getAutoDisponibiliSignIn(Model m, @PathVariable("data") String dataPrenotazione) {
		// prendo la data come stringa e la trasformo in un array di int per creare la data
		int[] data= new int[3];
		String[] dataStrArr=dataPrenotazione.split("-");
		for (int i = 0; i < data.length; i++) {
			data[i]= Integer.parseInt(dataStrArr[i]);
		
		}
		
		System.out.println("Ecco i veicoli\n"+vs.findVeicoloByDate(LocalDate.of(data[0], data[1], data[2]))+"\n");
		
		List veicoli=vs.findVeicoloByDate(LocalDate.of(data[0], data[1], data[2]) );

		m.addAttribute("veicoli", veicoli );
		
		return new ModelAndView("home");
	}
	@GetMapping("/data={data}/utente={id}")
	public ModelAndView getAutoDisponibiliLoggedIn(Model m, @PathVariable("data") String dataPrenotazione,  @PathVariable("id") String id ) {
		// recupero l'utente
		Utente acquirente= us.findUserById(Integer.parseInt(id));

		// prendo la data come stringa e la trasformo in un array di int per creare la data
		int[] data= new int[3];
		String[] dataStrArr=dataPrenotazione.split("-");
		for (int i = 0; i < data.length; i++) {
			data[i]= Integer.parseInt(dataStrArr[i]);
		
		}
		
		// System.out.println("Ecco i veicoli\n"+vs.findVeicoloByDate(LocalDate.of(data[0], data[1], data[2]))+"\n");
		
		List veicoli=vs.findVeicoloByDate(LocalDate.of(data[0], data[1], data[2]) );

		m.addAttribute("veicoli", veicoli );
		m.addAttribute("utente", acquirente);
		
		return new ModelAndView("home");
	}
	

	
	
}
