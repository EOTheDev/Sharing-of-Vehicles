package it.generation.sharingofvehicles.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;




/*author Edoardo Orta*/
@Entity
@Table(name = "veicolo")
public class Veicolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected int ruote;
	protected String tipologia;
	protected String alimentazione;
	protected String descrizione;
	protected String posizioneAttuale;
	protected String immagineVeicolo;
	protected double pesoCO2;
	protected double prezzo;
	@OneToOne
	//Admin che ha creato il veicolo
	protected Admin utenteID; 
	
	
	//constructors
	
	
	//getters and setters
	public int getId() {
		return id;
	}
	public Veicolo(String tipologia, String alimentazione, String descrizione,
			String posizioneAttuale, String immagineVeicolo, double prezzo, Admin utenteID) {
		this.id = -1;
		this.tipologia = tipologia;
		this.alimentazione = alimentazione;
		this.descrizione = descrizione;
		this.posizioneAttuale = posizioneAttuale;
		this.immagineVeicolo = immagineVeicolo;
		this.ruote = calcolaRuote(tipologia);					// 		bici, auto, scooter, monopattino
		this.pesoCO2 = calcolaCO2(tipologia, alimentazione); 	//		bici, auto, scooter, monopattino
																//      Bicicletta: 1
																//      Bicicletta elettrica : 0.95
																//		Monopattino: 0,95
																//		Auto Elettrica: 0,6
																//		Auto Ibrida: 0,4
																//		Auto Benzina: 0
																//		Auto Diesel: 0
		this.prezzo = prezzo;
		this.utenteID = utenteID;
	}
	
	
	
	private double calcolaCO2(String tipologia2, String alimentazione2) {
		switch (tipologia2) {
		case "bici":
			switch (alimentazione2) {
			case "elettrica":
				return 0.95;
			default:
				return 1.00;
			} 
			
			
		case "monopattino":
			return 0.95;
			
			
		case "scooter":
			switch (alimentazione2) {
			case "elettrica":
				return 0.90;
				
			default:
				return 0.50;
			} 
			
			
		default: //auto
			switch (alimentazione2) {
			case "ibrida":
				return 0.4;
				
			case "elettrica":
				return 0.6;
			default:
				return 0;
			}
		}
	}
	
	
	private int calcolaRuote(String tipologia2) {
		//se auto return 4
		if (tipologia2.equalsIgnoreCase("auto")){
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
		this.ruote = ruote;
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
	public String getPosizioneAttuale() {
		return posizioneAttuale;
	}
	public void setPosizioneAttuale(String posizioneAttuale) {
		this.posizioneAttuale = posizioneAttuale;
	}
	public String getImmagineVeicolo() {
		return immagineVeicolo;
	}
	public void setImmagineVeicolo(String immagineVeicolo) {
		this.immagineVeicolo = immagineVeicolo;
	}
	public double getPesoCO2() {
		return pesoCO2;
	}
	public void setPesoCO2(double pesoCO2) {
		this.pesoCO2 = pesoCO2;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public Admin getUtenteID() {
		return utenteID;
	}
	public void setUtenteID(Admin utenteID) {
		this.utenteID = utenteID;
	}
	@Override
	public String toString() {
		//TODO
		return "Veicolo [id=" + id + ", ruote=" + ruote + ", tipologia=" + tipologia + ", alimentazione="
				+ alimentazione + ", descrizione=" + descrizione + ", posizioneAttuale=" + posizioneAttuale
				+ ", immagineVeicolo=" + immagineVeicolo + ", pesoCO2=" + pesoCO2 + ", prezzo=" + prezzo + ", utenteID="
				+ utenteID + "]";
	}
	
	
	
	
	
	
	
	
	
}
