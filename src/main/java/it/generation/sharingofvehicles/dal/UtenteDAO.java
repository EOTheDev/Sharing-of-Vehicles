package it.generation.sharingofvehicles.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.generation.sharingofvehicles.entities.Utente;


/*author Edoardo Orta*/
public interface UtenteDAO extends JpaRepository<Utente, Integer>{


	Utente findUtenteByEmail(String email);
	
	
	
	Utente findUtenteById(int id);
	
}
