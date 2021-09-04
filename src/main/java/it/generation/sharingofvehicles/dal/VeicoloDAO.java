/*Author Giancarlo Borreo*/

package it.generation.sharingofvehicles.dal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.generation.sharingofvehicles.entities.Veicolo;

public interface VeicoloDAO extends JpaRepository<Veicolo, Integer> {

//	@Query(value="from veicoli where tipologia=?1")
	List<Veicolo> findVeicoloByTipologia(String tipologia);
	
//	@Query(value="from veicoli where alimentazione=?1")
	List<Veicolo> findVeicoloByAlimentazione(String alimentazione);
	
//	@Query(value="from veicoli where ruote=?1")
	List<Veicolo> findVeicoloByRuote(int ruote);
	
	
	@Query(value = "Select * FROM veicoli v LEFT JOIN prenotazioni p ON !(veicolo_id=v.id) WHERE data_prenotazione= ?1 ;", nativeQuery = true)
	List<Veicolo> findVeicoloByDate(LocalDate data);
}
