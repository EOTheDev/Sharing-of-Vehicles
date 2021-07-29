package it.generation.sharingofvehicles.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*author Edoardo Orta*/

@Entity
@Table(name="utenti")
public class Utente {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String username;
	protected String nome;
	protected String cognome;
	protected String nascita;
	protected String email;
	protected String password;
	protected LocalDate dataIscrizione;
	protected String tipo= "B";
	protected String firma="Cliente dal "+this.getdataIscrizione();	
	
	@OneToMany(mappedBy = "utenteId")
	private List<Veicolo> veicoli;
	
	@OneToMany(mappedBy = "utenteId")
	private List<Prenotazione> prenotazione;
	
	












	public List<Veicolo> getVeicoli() {
		return veicoli;
	}





	public void setVeicoli(List<Veicolo> veicoli) {
		this.veicoli = veicoli;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public LocalDate getDataIscrizione() {
		return dataIscrizione;
	}





	public void setDataIscrizione(LocalDate dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
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
	public LocalDate getdataIscrizione() {
		return dataIscrizione;
	}
	public void setdataIscrizione(LocalDate dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}





	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", nome=" + nome + ", cognome=" + cognome + ", nascita="
				+ nascita + ", email=" + email + ", password=" + password + ", dataIscrizione=" + dataIscrizione
				+ ", tipo=" + tipo + ", firma=" + firma + "]";
	}
	
	
	
	
	


}
