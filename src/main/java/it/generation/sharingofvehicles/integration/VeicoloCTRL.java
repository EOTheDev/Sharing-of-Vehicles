package it.generation.sharingofvehicles.integration;

import java.time.LocalDate;
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

import it.generation.sharingofvehicles.entities.Utente;
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
	
	@GetMapping("/{id}/data={data}")
	public ModelAndView viewAutomobile(Model m, @PathVariable("id") int id, @PathVariable("data") String dataPrenotazione) {
		
		int[] data = dataDaStringaAdArrayInt(dataPrenotazione);
		LocalDate dataDellaPrenotazione = LocalDate.of(data[0], data[1], data[2]);
		
		m.addAttribute("veicolo", vs.findVeicoloById(id));
		
		return new ModelAndView("singoloVeicolo");
	}
	
	@GetMapping("/{id}/{utenteId}/data={data}")
	public ModelAndView viewAutomobile(Model m, @PathVariable("id") int id, @PathVariable("utenteId") int utenteId, @PathVariable("data") String dataPrenotazione) {
		int[] data = dataDaStringaAdArrayInt(dataPrenotazione);
		LocalDate dataDellaPrenotazione = LocalDate.of(data[0], data[1], data[2]);

		Utente u= us.findUserById(utenteId);
		m.addAttribute("veicolo", vs.findVeicoloById(id));
		m.addAttribute("utente", u);
		return new ModelAndView("singoloVeicolo");
	}

	private int[] dataDaStringaAdArrayInt(String dataPrenotazione) {
		// prendo la data come stringa e la trasformo in un array di int per creare la data
		int[] data= new int[3];
		String[] dataStrArr=dataPrenotazione.split("-");
		for (int i = 0; i < data.length; i++) {
			data[i]= Integer.parseInt(dataStrArr[i]);
		}
		return data;
	}
	

	
	
}
