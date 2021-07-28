package it.generation.sharingofvehicles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.generation.sharingofvehicles.entities.Prenotazione;
import it.generation.sharingofvehicles.entities.Utente;
import it.generation.sharingofvehicles.entities.Veicolo;
import it.generation.sharingofvehicles.dal.UtenteDAO;

@Service
public class UtenteServiceImpl implements UtenteService{

	@Autowired
	private UtenteDAO repo;
	
	//metodi supporto Admin
	public void setAdmin(Utente u) {
		u.setTipo("A");
		u.setFirma("Amministratore dei Servizi");
		}
	public void unsetAdmin(Utente u) {
		u.setTipo("B");
		u.setFirma("Cliente dal "+u.getdataIscrizione());
		}
	
	public void setDisponibilita(Veicolo v) {
	//TODO
		//prenotazione 
	}
	
//	public void addVeicolo() {
//	//TODO
//	}
//	public void editVeicolo() {
//		//TODO
//	}
//	public void deleteVeicolo() {
//		//TODO
//		}
//	public void trovaPrenotazioni() {
//		//TODO
//		}
	
	
	
	/*metodi supplementari Registrato*/
//	public Prenotazione prenotaVeicolo(Veicolo v) {
//		//TODO
//		return null;
//	}
//	public Prenotazione modificaPrenotazione(Prenotazione vecchia, Prenotazione nuova) {
//		//TODO
//		return null;
//	}
	
	
	
	//metodi service

	@Override
	public List<Utente> findAllUsers() {
		return repo.findAll();
	}

	@Override
	public Utente findUserById(String id) {
//		return repo.findById(id).get();
		return repo.findUtenteByUserID(id);
	}

	@Override
	public void deleteUserById(String id) {
		//repo.deleteById(id);
		repo.deleteUtenteByUserID(id);;
	}

	@Override
	public Utente updateUser(Utente user) {
		return repo.save(user);
	}

	@Override
	public Utente addUser(Utente user) {
		return repo.save(user);
	}

	@Override
	public Utente findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findUtenteByEmail(email); //repo.findUserByEmail(email);
	}
}