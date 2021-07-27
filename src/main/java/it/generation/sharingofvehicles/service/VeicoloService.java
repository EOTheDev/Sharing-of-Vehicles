package it.generation.sharingofvehicles.service;

import java.util.List;

import it.generation.sharingofvehicles.entities.Veicolo;

public interface VeicoloService {
	
	List<Veicolo> findAllVeicoli();
	List<Veicolo> findVeicoloByTipologia(String tipologia);
	List<Veicolo> findVeicoloByAlimentazione(String alimentazione);
	Veicolo findVeicoloById(int id);
	void addVeicolo(Veicolo v);
	void deleteVeicoloById(int id);
	List<Veicolo> findVeicoloByRuote(int ruote);
	Veicolo updVeicolo(Veicolo v);
	
	
	

}
