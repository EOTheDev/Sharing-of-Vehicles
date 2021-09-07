package it.generation.sharingofvehicles.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import antlr.StringUtils;
import it.generation.sharingofvehicles.dal.PrenotazioneDAO;
import it.generation.sharingofvehicles.dal.VeicoloDAO;
import it.generation.sharingofvehicles.entities.Veicolo;
import it.generation.sharingofvehicles.config.*;
import it.generation.sharingofvehicles.util.*;

@Service
public class VeicoloServiceImpl implements VeicoloService {
	@Autowired
	PrenotazioneDAO prenotazioneRepo;
	@Autowired
	VeicoloDAO repo;
	
	@Override
	public List<Veicolo> findAllVeicoli() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Veicolo> findVeicoloByTipologia(String tipologia) {
		// TODO Auto-generated method stub
		return repo.findVeicoloByTipologia(tipologia);
	}

	@Override
	public List<Veicolo> findVeicoloByAlimentazione(String alimentazione) {
		// TODO Auto-generated method stub
		return repo.findVeicoloByAlimentazione(alimentazione);
	}

	@Override
	public Veicolo findVeicoloById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public Veicolo addVeicolo(Veicolo v) {
		// TODO Auto-generated method stub
		return repo.save(v);
	}

	@Override
	public void deleteVeicoloById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<Veicolo> findVeicoloByRuote(int ruote) {
		// TODO Auto-generated method stub
		return repo.findVeicoloByRuote(ruote);
	}

	@Override
	public Veicolo updVeicolo(Veicolo v) {
		// TODO Auto-generated method stub
		return repo.save(v);
	}

	@Override
	public List<Veicolo> findVeicoloByDate(LocalDate data) {
		List<Integer> veicoliPrenotati=	prenotazioneRepo.findIdVeicolobyDate(data);
		List veicoli=repo.findVeicoloByVeicoliPrenotati(veicoliPrenotati);
		System.out.println(veicoli);
		if (veicoli.size()==0) {
			// System.out.println("sono un drago, olè olè olè olè");
			veicoli=repo.findAll();
		}
		return veicoli;
	}

	@Override
	public Veicolo addVeicolo(Veicolo veicolo, MultipartFile multipartFile) {
		// 1) nome del file o immagine
		 // 2) setto nome del file prima di salvare il veicolo
		 // 3) salvo il veicolo
		 // 4) genero il percorso della cartella dove salvare l'immagine
		 // 5) classe utility con metodo statico che salva il file
		 // 6) restituisco il veicolo salvato
		
		//1
		//String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String fileName = CustomProperties.defaultImgName;
		
		//2
		veicolo.setImmagine(fileName);
		
		//3
		Veicolo veicoloSalvato = repo.save(veicolo);

		//4
		String uploadDir = CustomProperties.basepath + "/" + veicoloSalvato.getId();
		 
        try {
        	//5
			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
        

        //6
		return veicoloSalvato;
	}

}
