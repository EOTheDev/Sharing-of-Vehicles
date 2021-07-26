package it.generation.sharingofvehicles.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import it.generation.sharingofvehicles.entities.Utente;

/*author Edoardo Orta*/
public interface UtenteDAO extends JpaRepository<Utente, Integer>{

}
