package it.generation.sharingofvehicles.service;

import java.util.List;
import it.generation.sharingofvehicles.entities.Prenotazione;
import it.generation.sharingofvehicles.entities.Utente;


public interface PrenotazioneService {
	
	List<Prenotazione> findAllPrenotazione();
	Prenotazione findPrenotazioneById(int id);
	List<Prenotazione> findPrenotazioneByUtenteId(int id);
	void deletePrenotazioneById(int id);
	Prenotazione updatePrenotazione(Prenotazione p);
	Prenotazione addPrenotazione(Prenotazione p);

}