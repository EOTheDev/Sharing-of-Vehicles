package it.generation.sharingofvehicles.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/*author Edoardo Orta*/
@Entity
@Table(name="prenotazioni")
public class Prenotazione {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="veicolo_id", nullable = false)
	private Veicolo veicoloId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="utente_id", nullable = false)
	private Utente utenteId;
	private LocalDate dataPrenotazione;
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Veicolo getVeicoloId() {
		return veicoloId;
	}
	public void setVeicoloId(Veicolo veicoloId) {
		this.veicoloId = veicoloId;
	}
	public Utente getUtenteId() {
		return utenteId;
	}
	public void setUtenteId(Utente utenteId) {
		this.utenteId = utenteId;
	}
	public LocalDate getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(LocalDate dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	
	
	
	
	
}
