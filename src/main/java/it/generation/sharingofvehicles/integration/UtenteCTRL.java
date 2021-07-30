//
//package it.generation.sharingofvehicles.integration;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import it.generation.sharingofvehicles.entities.Utente;
//import it.generation.sharingofvehicles.service.PrenotazioneService;
//import it.generation.sharingofvehicles.service.UtenteService;
//import it.generation.sharingofvehicles.service.VeicoloService;
//
//@RestController
//@RequestMapping("/dashboard")
//public class UtenteCTRL {
//	
//	@Autowired
//	private UtenteService us;
//	@Autowired
//	private VeicoloService vs;
//	@Autowired
//	private PrenotazioneService ps;
//	
//	@GetMapping
//	public ModelAndView login(Model m) {
//		m.addAttribute("utenti",us.findAllUsers());   
//		System.out.println("sono in get");
//		
//		return new ModelAndView("login");
//	}
//	
//	@PostMapping
//	public ModelAndView enterDashboard(Model m, 
//			@RequestParam String email
//			) {
//		
//		Utente u = us.findUserByEmail(email);
//		
//		if(u != null) {
//			
//			switch (u.getTipo()) {
//			
//			case "A":
//				m.addAttribute("utenti", us.findAllUsers());
//				m.addAttribute("veicoli" , vs.findAllVeicoli());
//				m.addAttribute("prenotazioni",ps.findAllPrenotazione());
//				return new ModelAndView("dashboard");
//				
//			case "B":
//				IndexCTRL ic = new IndexCTRL();
//				return ic.getIndex(m);
//				
//			
//			default:
//				return new ModelAndView("registrati");
//				
//			}
//		}
//			else {
//				return new ModelAndView("registrati");
//			}
//			
////		return new ModelAndView("dashboard");
//	}
//	
//
//}
