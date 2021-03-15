package com.rustica.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rustica.demo.modelo.Domicilio;
import com.rustica.demo.servicio.DomicilioServicio;

@Controller
@RequestMapping
public class Controlador_Domicilio {
	
	@Autowired
	private DomicilioServicio domicilioservicio;
	
	@GetMapping("/listadodomicilio")
	public String listardomicilio(Model model) {
		List<Domicilio>domicilios= domicilioservicio.listar();
		model.addAttribute("domicilios",domicilios);
		return "listadodomicilio";
	}
	
	@GetMapping("/listadomicilioadmin")
	public String listardomicilioadmin(Model model) {
		List<Domicilio>domiciliosadmin=domicilioservicio.listaradmin();
		model.addAttribute("domiciliosadmin",domiciliosadmin);
		return "listadomicilioadmin";
	}
	
	@GetMapping("/man_domicilio")
	public String agregardomicilio(Model model){
		model.addAttribute("domicilios",new Domicilio());
		return "man_domicilio";
	}
	
	@PostMapping("/save_domicilio")
	public String save(Domicilio p, Model model, RedirectAttributes attribute,BindingResult result) {		
		domicilioservicio.save(p);		
		if(result.hasErrors()) {
		System.out.println("Existieron errores en el formulario");			
		return "man_domicilio";
		}
		System.out.println("El domicilio se guardo con exito!");
		attribute.addFlashAttribute("success", "Domicilio guardado con exito!");
		return "redirect:/listadodomicilio";
	}
	
	@GetMapping("/domicilio_eliminar/{iddomicilio}")
	public String eliminardomicilio(Model model, @PathVariable int iddomicilio,RedirectAttributes attribute) {
		domicilioservicio.delete(iddomicilio);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
		return "redirect:/listadodomicilio";
	}
	
	@GetMapping("/domicilio_eliminaradmin/{iddomicilio}")
	public String eliminardomicilioadmin(Model model, @PathVariable int iddomicilio,RedirectAttributes attribute) {
		domicilioservicio.delete(iddomicilio);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
		return "redirect:/listadomicilioadmin";
	}
	
	@GetMapping("/domicilio_editar/{iddomicilio}")
	public String editardomicilio(@PathVariable int iddomicilio,Model model) {
		Optional<Domicilio>domicilios=domicilioservicio.listarId(iddomicilio);
		model.addAttribute("domicilios",domicilios);
		return "man_domicilio";
	}
	
	@GetMapping("/detalle_domicilio/{iddomicilio}")
	public String detalleDomicilio(@PathVariable int iddomicilio,Model model, RedirectAttributes attribute) {
		Domicilio domicilio = null;
		if(iddomicilio >0) {
			domicilio=domicilioservicio.buscarPorId(iddomicilio);
			if(domicilio==null) {
				attribute.addFlashAttribute("error","atencion:El id del domicilio no existe!");
				return "redirect:/listadomicilioadmin";
			}
		
		}else {
			attribute.addFlashAttribute("error","atencion: Error con el id del domicilio!");
			return "redirect:/listadomicilioadmin";
		}
		
		
		model.addAttribute("titulo","Detalle del Domicilio:"+domicilio.getCalle());
		model.addAttribute("domicilio",domicilio);
		return "detalleDomicilio";
	}
	
	@GetMapping("/mapa")
	public String mapa(Model model) {
		return "mapa";
	}	

}
