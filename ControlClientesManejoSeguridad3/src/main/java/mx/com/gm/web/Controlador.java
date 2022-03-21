package mx.com.gm.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.service.PersonaService;


@Controller
@Slf4j
public class Controlador {

	@Autowired
	private PersonaService personaService;
	

	@GetMapping("/")
	public String inicio(Model model, @AuthenticationPrincipal User user) {
		var personas = personaService.listaPersonas();
		log.info("Ejecutando el controlador Spring MVC");
		log.info("USUARIO DE LOGIN"+ user);
		model.addAttribute("personas", personas);
		return "index";
	}
	
	@GetMapping("/agregar")
		public String agregar(Persona persona) {
			return "modificar";
	}
	
	@PostMapping("/guardar")
		public String guardar(@Valid Persona persona, Errors erros) {
		if(erros.hasErrors()) {
			return "modificar";
		}
		personaService.guardar(persona);
		return "redirect:/";
	}
	@GetMapping("/editar/{idpersona}")
		public String editar(Persona persona, Model model) {
			persona = personaService.encontrarPersona(persona);
			model.addAttribute("persona", persona);
			return "modificar";
	}
	@GetMapping("/eliminar/{idpersona}")
		public String eliminar(Persona persona) {
			personaService.eliminar(persona);
			return "redirect:/";
	}
}
