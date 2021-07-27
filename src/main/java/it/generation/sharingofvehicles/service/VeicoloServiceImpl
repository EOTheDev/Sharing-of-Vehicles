package it.generation.sharingofvehicles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.generation.sharingofvehicles.dal.VeicoloDAO;
import it.generation.sharingofvehicles.entities.Veicolo;

public class VeicoloServiceImpl implements VeicoloService {

	@Autowired
	VeicoloDAO repo;
	
	@Override
	public List<Veicolo> findAllVeicoli() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Veicolo> findVeicoloByTipologia(String tipologia) {
		// TODO Auto-generated method stub
		return repo.findVeicoloByTipologia(tipologia);
	}

	@Override
	public List<Veicolo> findVeicoloByAlimentazione(String alimentazione) {
		// TODO Auto-generated method stub
		return repo.findVeicoloByAlimentazione(alimentazione);
	}

	@Override
	public Veicolo findVeicoloById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void addVeicolo(Veicolo v) {
		// TODO Auto-generated method stub
		repo.save(v);
	}

	@Override
	public void deleteVeicoloById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<Veicolo> findVeicoloByRuote(int ruote) {
		// TODO Auto-generated method stub
		return repo.findVeicoloByRuote(ruote);
	}

	@Override
	public Veicolo updVeicolo(Veicolo v) {
		// TODO Auto-generated method stub
		return repo.save(v);
	}

}
