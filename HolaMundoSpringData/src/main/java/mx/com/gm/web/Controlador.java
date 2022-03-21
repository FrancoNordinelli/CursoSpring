package mx.com.gm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.IPersonaDao;


@Controller
@Slf4j
public class Controlador {

	@Autowired
	private IPersonaDao personaDao;
	

	@GetMapping("/")
	public String inicio(Model model) {
		var personas = personaDao.findAll();
		log.info("Ejecutando el controlador Spring MVC");
		model.addAttribute("personas", personas);
		return "index";
	}

}
