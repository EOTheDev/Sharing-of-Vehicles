package it.generation.sharingofvehicles.integration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexCTRL {
	
@GetMapping("/")
public String getIndex() {
	
	System.out.println("sono in index");
	return "index";
}
}
