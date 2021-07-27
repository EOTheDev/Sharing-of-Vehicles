package it.generation.sharingofvehicles.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import it.generation.sharingofvehicles.entities.Prenotazione;

public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Integer> {

}
