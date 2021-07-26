package it.generation.sharingofvehicles.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;


/*author Edoardo Orta*/
@Entity
@Table(name="utenti")
public class UtenteRegistrato extends Utente{
	
	protected String tipo= "B";
	protected String firma="Cliente dal "+this.getDataIscrizione();
	
	
	
	/*metodi supplementari*/
	public Prenotazione prenotaVeicolo(Veicolo v) {
		return null;
	}
	public Prenotazione modificaPrenotazione(Prenotazione vecchia, Prenotazione nuova) {
		return null;

	}
	
	
	public UtenteRegistrato() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UtenteRegistrato(String userID, String nome, String cognome, String nascita, String email, String password,
			LocalDate dataIscrizione) {
		super(userID, nome, cognome, nascita, email, password, dataIscrizione);
		// TODO Auto-generated constructor stub
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
		return super.toString()+"UtenteRegistrato [tipo=" + tipo + ", firma=" + firma + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


	
