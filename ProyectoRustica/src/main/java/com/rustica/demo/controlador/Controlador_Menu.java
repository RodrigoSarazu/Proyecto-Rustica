package com.rustica.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Controlador_Menu {	
	
	@GetMapping("/menu")
	public String menu(Model model) {
		return "menu";
	}
	
	@GetMapping("/admin")
	public String menuadmin(Model model) {
		return "admin";
	}

	@GetMapping("/vista_salir")
	public String paginasalir(Model model) {		
		return "redirect:/login";
	}
	

}
