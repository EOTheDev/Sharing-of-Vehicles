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
		u.setFirma("Cliente dal "+u.getDataIscrizione());
		}
	
	public void setDisponibilita(Veicolo v) {}
	//TODO
		//prenotazione 

	
	//metodi service

	@Override
	public List<Utente> findAllUsers() {
		return repo.findAll();
	}

	@Override
	public Utente findUserById(int id) {
	//	return repo.findById(id).get();
		return repo.findUtenteById(id);
	}

	@Override
	public void deleteUserById(int id) {
		//repo.deleteById(id);
		repo.deleteById(id);;
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