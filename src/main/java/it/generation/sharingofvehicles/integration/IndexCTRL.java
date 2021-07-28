package it.generation.sharingofvehicles.integration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexCTRL {
	
@GetMapping("/")
public String getIndex() {
	
	System.out.println("sono in index");
	return "home";
}

@GetMapping("login")
public ModelAndView login(Model m) {
	return new ModelAndView("login");
}

}
