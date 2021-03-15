package com.rustica.demo.controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rustica.demo.modelo.Comida;
import com.rustica.demo.servicio.ComidaServicio;

@Controller
@RequestMapping
public class Controlador_Comida {
	
	@Autowired
	private ComidaServicio comidaservicio;
	
	@GetMapping("/listadocomida")
	public String listarcomida(Model model) {
		List<Comida>comidas= comidaservicio.listar();
		model.addAttribute("comidas",comidas);
		return "listadocomida";
	}
		
	@GetMapping("/listadocomidaadmin")
	public String listarcomidaadmin(Model model) {
		List<Comida>comidasadmin=comidaservicio.listaradmin();
		model.addAttribute("comidasadmin",comidasadmin);
		return "listadocomidaadmin";
	}
	
	@GetMapping("/man_comida")
	public String agregarcomida(Model model){
		model.addAttribute("comidasadmin",new Comida());
		return "man_comida";
	}
	
	@PostMapping("/save_comida")
	public String savecomida(Comida p,Model model, @RequestParam("file")MultipartFile imagen, RedirectAttributes attribute,BindingResult result) {
			if(!imagen.isEmpty()) {
				Path directorioImagenes= Paths.get("src//main//resources//static/img");
				String rutaAbsoluta =directorioImagenes.toFile().getAbsolutePath();
				try {
					byte[]bytesImg=imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta+"//"+ imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);
					p.setImagen(imagen.getOriginalFilename());
				} catch (IOException e) {
				
					e.printStackTrace();
				}		
		}		
		comidaservicio.save(p);
		System.out.println("La comida se guardo con exito!");
		attribute.addFlashAttribute("success", "Comida guardada con exito!");
		return "redirect:/listadocomidaadmin";
	}
	
	@GetMapping("/detalle/{idcom}")
	public String detalleComida(@PathVariable int idcom,Model model, RedirectAttributes attribute) {
		Comida comida = null;
		if(idcom >0) {
			comida=comidaservicio.buscarPorId(idcom);
			if(comida==null) {
				attribute.addFlashAttribute("error","atencion:El id de la comida no existe!");
				return "redirect:/listadocomidaadmin";
			}
		}else{
			attribute.addFlashAttribute("error","atencion: Error con el id de la comida!");
			return "redirect:/listadocomidaadmin";
		}
		model.addAttribute("titulo","Detalle de la comida:"+comida.getNombre());
		model.addAttribute("comida",comida);
		return "detalleComida";
	}
	
	
	
	@GetMapping("/comida_editar/{idcom}")
	public String editarcomida(@PathVariable int idcom,Model model) {
		Optional<Comida>comidasadmin=comidaservicio.listarId(idcom);
		model.addAttribute("comidasadmin",comidasadmin);
		return "man_comida";
	}
	
	@GetMapping("/comida_eliminar/{idcom}")
	public String eliminarcomida(Model model, @PathVariable int idcom ,RedirectAttributes attribute) {
		comidaservicio.delete(idcom);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
		return "redirect:/listadocomidaadmin";
	}

}
