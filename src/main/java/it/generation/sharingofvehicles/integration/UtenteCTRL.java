package it.generation.sharingofvehicles.integration;

import it.generation.sharingofvehicles.entities.Prenotazione;
import it.generation.sharingofvehicles.entities.Utente;
import it.generation.sharingofvehicles.entities.Veicolo;

public class UtenteCTRL {
	
	
	
	
	
	
	
	
	

	//metodi supporto Admin
	public void setAdmin(Utente u) {
		u.setTipo("A");
		u.setFirma("Amministratore dei Servizi");
		}
	public void unsetAdmin(Utente u) {
		u.setTipo("B");
		u.setFirma("Cliente dal "+u.getDataIscrizione());
		}
	
	public void setDisponibilita(Veicolo v) {
	//TODO
	}
	
	public void addVeicolo() {
	//TODO
	}
	public void editVeicolo() {
		//TODO
	}
	public void deleteVeicolo() {
		//TODO
		}
	public void trovaPrenotazioni() {
		//TODO
		}
	
	
	
	/*metodi supplementari Registrato*/
	public Prenotazione prenotaVeicolo(Veicolo v) {
		return null;
	}
	public Prenotazione modificaPrenotazione(Prenotazione vecchia, Prenotazione nuova) {
		return null;

	}
	
}
