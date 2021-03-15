package com.rustica.demo.controlador;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rustica.demo.modelo.Userrustica;
import com.rustica.demo.servicio.UserrusticaServicio;

@Controller
@RequestMapping
public class Controlador_Administrador {
	
	@Autowired
	private UserrusticaServicio userrusticaservicio;
	
	@GetMapping("/loginadmin")
	public ModelAndView loginadmin(Model model){
		ModelAndView mav=new ModelAndView("loginadmin");
		mav.addObject("userrustica", new Userrustica());
		return mav;
	}
	@PostMapping("/loginadmin")
	public String loginadmin(@ModelAttribute("userrustica") Userrustica userrustica,RedirectAttributes attribute) {
		Userrustica oauthUser=userrusticaservicio.loginadmin(userrustica.getUsername(), userrustica.getPassword());
		System.out.print(oauthUser);		
		if(Objects.nonNull(oauthUser)) { 
			return "admin";	
		}else {
			attribute.addFlashAttribute("success","No puedo ingresar a la página");
			return "redirect:/loginadmin";	
		}
	}
	
	@GetMapping("/listadoadmin")
	public String listaradmin(Model model) {
		List<Userrustica>userrusticas= userrusticaservicio.listaradmin();
		model.addAttribute("userrusticas",userrusticas);
		return "listadoadmin";
	}
	
	@GetMapping("/man_admin")
	public String agregaradmin(Model model){
		model.addAttribute("userrusticas",new Userrustica());
		return "man_admin";
	}	
	
	@PostMapping("/save_admin")
	public String save(Userrustica p, Model model, RedirectAttributes attribute,BindingResult result) {
		if(result.hasErrors()) {
		System.out.println("Existieron errores en el formulario");			
		return "man_admin";
		}
		userrusticaservicio.save(p);
		System.out.println("El administrador se guardo con exito!");
		attribute.addFlashAttribute("success", "Administrador guardado con exito!");
		return "redirect:/listadoadmin";
	}
	
	@GetMapping("/admin_eliminar/{user_id}")
	public String eliminaradmin(Model model, @PathVariable int user_id, RedirectAttributes attribute) {
		userrusticaservicio.delete(user_id);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
		return "redirect:/listadoadmin";
	}
	
	@GetMapping("/admin_editar/{user_id}")
	public String editaradmin(@PathVariable int user_id,Model model) {
		Optional<Userrustica>userrusticas=userrusticaservicio.listarId(user_id);
		model.addAttribute("userrusticas",userrusticas);
		return "man_admin";
	}

}
