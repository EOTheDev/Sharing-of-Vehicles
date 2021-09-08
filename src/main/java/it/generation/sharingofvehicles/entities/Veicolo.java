package it.generation.sharingofvehicles.entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import it.generation.sharingofvehicles.config.CustomProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;




/*author Edoardo Orta */
@Entity
@Table(name = "veicoli")
public class Veicolo {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String tipologia;
	protected String alimentazione;
	protected String descrizione;
	protected String indirizzo;
	protected int latitudine;
	protected int longitudine;
	protected String immagine;
	protected String modello;
	protected double pesoCo2;
	protected double prezzo;
	protected int ruote;
	//Admin che ha creato il veicolo
	protected String colore = "#f2e5r4";
	
//	@OneToMany(mappedBy = "viaggio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	
	public String getColore() {
		return colore;
	}




	public void setColore(String colore) {
		this.colore = colore;
	}



	@ManyToOne
	@JoinColumn(name="utente_id", nullable = false)
	protected Utente utenteId; 
	
	@OneToMany(mappedBy = "veicoloId")
	List<Prenotazione> prenotazioniVeicolo;
	
	//constructors
	
	
	//getters and setters
	public int getId() {
		return id;
	}

	
	
	
	private double calcolaCO2() {
		switch (tipologia) {
		case "Bici":
			switch (alimentazione) {
			case "Elettrica":
				return 0.95;
			default:
				return 1.00;
			} 
			
			
		case "Monopattino":
			return 0.95;
			
			
		case "Moto":
			switch (alimentazione) {
			case "Elettrica":
				return 0.90;
				
			default:
				return 0.50;
			} 
			
			
		default: //auto
			switch (alimentazione) {
			case "Ibrida":
				return 0.4;
				
			case "Elettrica":
				return 0.6;
			default:
				return 0;
			}
		}
	}
	
	@Transient // non viene salvata su database
    public String getPhotosImagePath() {

		// 1) percorso immagine di default se non è stata caricata
		// 2) percorso immagine caricata

		if (immagine == null || immagine.equals("")) {
        	//1
        	return "/" + CustomProperties.defaultImg;        	
        }

        //2
        return "/" + CustomProperties.basepath + "/" + id + "/" + immagine;
    }
	
	
	private int calcolaRuote() {
		//se auto return 4
		if (tipologia.equalsIgnoreCase("Auto")){
			return 4;
		} else { //bici, scooter, monopattino
			return 2;
		}
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getRuote() {
		return ruote;
	}
	public void setRuote(int ruote) {
		ruote =	calcolaRuote();
		
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getAlimentazione() {
		return alimentazione;
	}
	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		
		this.immagine = immagine;
	}



	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public double getPesoCo2() {
		return pesoCo2;
	}



	public void setPesoCo2(double pesoCo2) {
		this.pesoCo2 = calcolaCO2();
	}



	public Utente getUtenteId() {
		return utenteId;
	}



	public void setUtenteId(Utente utenteId) {
		this.utenteId = utenteId;
	}



	public String getModello() {
		return modello;
	}



	public void setModello(String modello) {
		this.modello = modello;
	}



	public String getIndirizzo() {
		return indirizzo;
	}



	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}



	public int getLatitudine() {
		return latitudine;
	}



	public void setLatitudine(int latitudine) {
		this.latitudine = latitudine;
	}



	public int getLongitudine() {
		return longitudine;
	}



	public void setLongitudine(int longitudine) {
		this.longitudine = longitudine;
	}

	
	









	
	
	
	
	
	
	
	
	
}
