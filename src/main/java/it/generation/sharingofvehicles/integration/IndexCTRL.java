package it.generation.sharingofvehicles.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.generation.sharingofvehicles.service.VeicoloService;

@Controller
public class IndexCTRL {
	
	@Autowired
	VeicoloService vs;
	
@GetMapping("/")
public String getIndex(Model m) {
	
	m.addAttribute("veicoli",vs.findAllVeicoli());
	
	System.out.println("sono in index");
	return "home";
}

@GetMapping("login")
public ModelAndView login(Model m) {
	return new ModelAndView("login");
}

}
