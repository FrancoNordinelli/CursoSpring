package mx.com.gm;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;

@Controller
@Slf4j
public class Controlador {
	
	@Value("${index.saludo}")
	private String saludo;
	
	@GetMapping("/")
	public String inicio(Model model) {
		var saludar = "Hola mundo con Thymeleaf";
		var persona = new Persona();
		persona.setApellido("Nordinelli");
		persona.setNombre("Franco");
		persona.setEmail("algo@gmail.com");
		persona.setTelefono("23232323");
		var persona2 = new Persona();
		persona2.setApellido("Nanni");
		persona2.setNombre("Viviana");
		persona2.setEmail("alg2o@gmail.com");
		persona2.setTelefono("231212232323");
		//var personas = new ArrayList();
		//personas.add(persona);
		//personas.add(persona2);
		//var personas = Arrays.asList(persona, persona2);
		var personas = Arrays.asList();
		log.info("Ejecutando el controlador Spring MVC");
		model.addAttribute("saludar", saludar);
		model.addAttribute("saludo", saludo);
		//model.addAttribute("persona", persona);
		model.addAttribute("personas", personas);
		return "index";
	}

}
