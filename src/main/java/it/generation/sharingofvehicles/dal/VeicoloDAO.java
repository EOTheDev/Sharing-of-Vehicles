package it.generation.sharingofvehicles.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import it.generation.sharingofvehicles.entities.Veicolo;

public interface VeicoloDAO extends JpaRepository<Veicolo, Integer> {

}
