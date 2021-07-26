package it.generation.sharingofvehicles.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*author Edoardo Orta*/
@Entity
@Table(name="prenotazioni")
public class Prenotazione {
	private int id;
	@OneToOne
	private Veicolo veicoloID;
	@OneToOne
	private Utente utenteID;
	private Date dataPrenotazione;
	
	
	
	public Prenotazione(int id, Veicolo veicoloID, Utente utenteID, Date dataPrenotazione) {
		super();
		this.id = id;
		this.veicoloID = veicoloID;
		this.utenteID = utenteID;
		this.dataPrenotazione = dataPrenotazione;
	}
	
	public Prenotazione() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Veicolo getVeicoloID() {
		return veicoloID;
	}
	public void setVeicoloID(Veicolo veicoloID) {
		this.veicoloID = veicoloID;
	}
	public Utente getUtenteID() {
		return utenteID;
	}
	public void setUtenteID(Utente utenteID) {
		this.utenteID = utenteID;
	}
	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	
	
	
	
	
}
