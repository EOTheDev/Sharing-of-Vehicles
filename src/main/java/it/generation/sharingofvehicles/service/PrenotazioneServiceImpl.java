package it.generation.sharingofvehicles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.generation.sharingofvehicles.dal.PrenotazioneDAO;
import it.generation.sharingofvehicles.entities.Prenotazione;
import it.generation.sharingofvehicles.entities.Utente;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {
	
	@Autowired
	private PrenotazioneDAO repo;
	
	@Override
	public List<Prenotazione> findAllPrenotazione() {
		
		return repo.findAll();
	}

	@Override	
	public Prenotazione findPrenotazioneById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Prenotazione> findPrenotazioneByUtenteId(String id) {
		//TODO
		return repo.findPrenotazioneByUtenteID(id);//repo.findById(utente.);
	}

	@Override
	public void deletePrenotazioneById(int id) {
		repo.deleteById(id);

	}

	@Override
	public Prenotazione updatePrenotazione(Prenotazione p) {
		return repo.save(p);
	}

	@Override
	public Prenotazione addPrenotazione(Prenotazione p) {
		return repo.save(p);

	}

}
