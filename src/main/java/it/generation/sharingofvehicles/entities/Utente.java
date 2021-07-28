package it.generation.sharingofvehicles.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*author Edoardo Orta*/

@Entity
@Table(name="utenti")
public class Utente {



	@Id
	protected String userID;
	protected String nome;
	protected String cognome;
	protected String nascita;
	protected String email;
	protected String password;
	protected LocalDate dataIscrizione;
	protected String tipo= "B";
	protected String firma="Cliente dal "+this.getDataIscrizione();	
	
	
	
	
	






	@Override
	public String toString() {
		return "Utente [userID=" + userID + ", nome=" + nome + ", cognome=" + cognome + ", nascita=" + nascita
				+ ", email=" + email + ", password=" + password + ", dataIscrizione=" + dataIscrizione + ", tipo="
				+ tipo + ", firma=" + firma + "]";
	}





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





//	public Utente() {
//	
//	}
//
//
//
//
//
//	public Utente(String userID, String nome, String cognome, String nascita, String email, String password,
//			LocalDate dataIscrizione) {
//		super();
//		this.userID = userID;
//		this.nome = nome;
//		this.cognome = cognome;
//		this.nascita = nascita;
//		this.email = email;
//		this.password = password;
//		this.dataIscrizione = dataIscrizione;
//	}
	
	
	
	
	
	//getters e setters
	
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNascita() {
		return nascita;
	}
	public void setNascita(String nascita) {
		this.nascita = nascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDataIscrizione() {
		return dataIscrizione;
	}
	public void setDataIscrizione(LocalDate dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}
	
	
	
	


}
