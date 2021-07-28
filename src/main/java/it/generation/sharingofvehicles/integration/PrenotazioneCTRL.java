/*Author Giancarlo Borreo*/

package it.generation.sharingofvehicles.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.generation.sharingofvehicles.entities.Prenotazione;
import it.generation.sharingofvehicles.service.PrenotazioneService;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneCTRL {
//
//	@Autowired
//	private PrenotazioneService ps;
//	
//	@GetMapping("/all")
//	List<Prenotazione> all(){
//		return ps.findAllPrenotazione();
//	}
}
