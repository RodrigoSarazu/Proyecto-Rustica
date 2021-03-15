package com.rustica.demo.controlador;

import java.util.List;
import java.util.Objects;

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

import com.rustica.demo.modelo.Usuario;
import com.rustica.demo.servicio.UsuarioServicio;

@Controller
@RequestMapping
public class Controlador_Usuario {
	
	@Autowired
	private UsuarioServicio usuarioservicio;
	
	@GetMapping("/login")
	public ModelAndView login(Model model){
		ModelAndView mav=new ModelAndView("login");
		mav.addObject("usuario", new Usuario());
		return mav;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("usuario") Usuario usuario,RedirectAttributes attribute) {
		Usuario oauthUser=usuarioservicio.login(usuario.getEmail(), usuario.getPassword());
		System.out.print(oauthUser);		
		if(Objects.nonNull(oauthUser)) { 
			return "menu";	
		}else {
			attribute.addFlashAttribute("success","No puedo ingresar a la página");
			return "redirect:/login";	
		}
	}
	
	@GetMapping("/registro")
	public String agregar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "RegistroLogin";
	}
	
	@PostMapping("/registro/save")
	public String save(Usuario usuario, Model model,BindingResult result ,
			RedirectAttributes attribute) {
		if (result.hasErrors()){
			model.addAttribute("usuario", usuario);
			attribute.addFlashAttribute("success", "No pudo Registrarse");
			return "RegistroLogin";
		}
		usuarioservicio.save(usuario);
		System.out.println("Se registro con exito!");
		attribute.addFlashAttribute("success", "Se registro con exito!");
		return "redirect:/login";
	}
	
	@GetMapping("/listadousuarios")
	public String listarusuario(Model model) {
		List<Usuario>usuarios=usuarioservicio.listarusuario();
		model.addAttribute("usuarios",usuarios);
		return "listadousuarios";
	}
	
	@GetMapping("/eliminar_usuario/{idusu}")
	public String eliminarusuario(@PathVariable int idusu, Model model,RedirectAttributes attribute) {
		usuarioservicio.delete(idusu);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
		return "redirect:/listadousuarios";
	}		
	
	@GetMapping("/detalle_usuario/{idusu}")
	public String detalleUsuario(@PathVariable int idusu,Model model, RedirectAttributes attribute) {
		Usuario usuario = null;
		if(idusu >0) {
			usuario=usuarioservicio.buscarPorId(idusu);
			if(usuario==null) {
				attribute.addFlashAttribute("error","atencion:El id del usuario no existe!");
				return "redirect:/listadousuarios";
			}
		
		}else {
			attribute.addFlashAttribute("error","atencion: Error con el id del usuario!");
			return "redirect:/listadousuarios";
		}
		
		
		model.addAttribute("titulo","Detalle del Usuario:"+usuario.getEmail());
		model.addAttribute("usuario",usuario);
		return "detalleUsuario";
	}

}
