/*Author Giancarlo Borreo*/

package it.generation.sharingofvehicles.dal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.generation.sharingofvehicles.entities.Prenotazione;


public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Integer> {

//	@Query(value="from prenotazioni where UtenteId=?1")
	List<Prenotazione> findPrenotazioneByUtenteId(int utenteId);
	@Query (value = "select distinct p.veicolo_id from prenotazioni p where data_prenotazione =?1", nativeQuery = true)
	List <Integer> findIdVeicolobyDate(LocalDate dataPrenotazione);
}

