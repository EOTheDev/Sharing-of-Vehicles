package it.generation.sharingofvehicles.config;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomProperties {

	// cartella dove salvare le immagini
	public static String basepath = "src/main/resources/static/imgUpl";
	
	// immagine di default del veicolo se non è stata caricata
	public static String defaultImg = basepath+"veicoloDefault.jpg";

	public static String defaultImgName = "veicolo.png";
	
}