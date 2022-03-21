package mx.com.gm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Controlador {
	
	@GetMapping("/")
	public String inicio() {
		log.info("Ejecutando el controlador Algo más");
		log.debug("Más detalle con debug");
		return "Hola mundo con Spring";
	}

}
