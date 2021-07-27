package it.generation.sharingofvehicles.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.generation.sharingofvehicles.entities.Veicolo;

public interface VeicoloDAO extends JpaRepository<Veicolo, Integer> {

	@Query(value="from Veicolo where tipologia=?1")
	List<Veicolo> findVeicoloByTipologia(String tipologia);
	
	@Query(value="from Veicolo where alimentazione=?1")
	List<Veicolo> findVeicoloByAlimentazione(String alimentazione);
	
	@Query(value="from veicolo where ruote=?1")
	List<Veicolo> findVeicoloByRuote(int ruote);	
}
