/*Author Giancarlo Borreo*/

package it.generation.sharingofvehicles.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.generation.sharingofvehicles.entities.Prenotazione;


public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Integer> {

//	@Query(value="from prenotazioni where UtenteId=?1")
	List<Prenotazione> findPrenotazioneByUtenteID(String utenteID);
}

