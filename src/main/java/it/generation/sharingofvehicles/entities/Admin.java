package it.generation.sharingofvehicles.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="utenti")
public class Admin extends Utente{
	protected String tipo= "A";
	protected String firma="Amministratore dei Servizi";
	
	
	
	//metodi supporto
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
	
	
	//constructor
	
	public Admin() {
		super();
	}
	
	public Admin(String userID, String nome, String cognome, String nascita, String email, String password,
			LocalDate dataIscrizione) {
		super(userID, nome, cognome, nascita, email, password, dataIscrizione);
	}
	
	
	//getters e setters


	public String getTipo() {
		return tipo;
	}








	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getFirma() {
		return firma;
	}



	public void setFirma(String firma) {
		this.firma = firma;
	}



	@Override
	public String toString() {
		return super.toString()+ "Admin [tipo=" + tipo + ", firma=" + firma + "]";
	}
	
}
