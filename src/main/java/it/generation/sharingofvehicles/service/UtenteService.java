package it.generation.sharingofvehicles.service;

import java.util.List;

import it.generation.sharingofvehicles.entities.Prenotazione;
import it.generation.sharingofvehicles.entities.Utente;
import it.generation.sharingofvehicles.entities.Veicolo;

public interface UtenteService {
	

	List<Utente> findAllUsers();
	Utente findUserByEmail(String email);
	Utente findUserById(String id);
	void deleteUserById(String id);
	Utente updateUser(Utente user);
	Utente addUser(Utente user);
	
	
	
	
}
