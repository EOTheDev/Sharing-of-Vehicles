package it.generation.sharingofvehicles.service;

import java.time.LocalDate;
import java.util.List;

import it.generation.sharingofvehicles.entities.Veicolo;

public interface VeicoloService {
	
	List<Veicolo> findAllVeicoli();
	List<Veicolo> findVeicoloByTipologia(String tipologia);
	List<Veicolo> findVeicoloByAlimentazione(String alimentazione);
	List<Veicolo> findVeicoloByDate(LocalDate data);
	Veicolo findVeicoloById(int id);
	Veicolo addVeicolo(Veicolo v);
	void deleteVeicoloById(int id);
	List<Veicolo> findVeicoloByRuote(int ruote);
	Veicolo updVeicolo(Veicolo v);
	
	
	

}
