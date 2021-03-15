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

import com.rustica.demo.modelo.Proveedor;
import com.rustica.demo.servicio.ProveedorServicio;

@Controller
@RequestMapping
public class Controlador_Proveedor {
	
	@Autowired
	private ProveedorServicio proveedorservicio;
	
	@GetMapping("/listadoproveedor")
	public String listarprov(Model model) {
		List<Proveedor>proveedores=proveedorservicio.listar();
		model.addAttribute("proveedores",proveedores);
		return "listadoproveedor";
	}
	
	@GetMapping("/man_proveedor")
	public String agregarprov(Model model){
		model.addAttribute("proveedores",new Proveedor());
		return "man_proveedor";
	}	
	
	@PostMapping("/save_proveedor")
	public String save(Proveedor p, Model model,RedirectAttributes attribute,BindingResult result) {
		if(result.hasErrors()) {
		System.out.println("Existieron errores en el formulario");			
		return "man_proveedor";
		}
		proveedorservicio.save(p);
		System.out.println("El proveedor se guardo con exito!");
		attribute.addFlashAttribute("success", "Proveedor guardado con exito!");
		return "redirect:/listadoproveedor";
	}
	
	@GetMapping("/proveedor_eliminar/{idprov}")
	public String eliminarprov(Model model, @PathVariable int idprov, RedirectAttributes attribute) {
		proveedorservicio.delete(idprov);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
		return "redirect:/listadoproveedor";
	}
	
	@GetMapping("/proveedor_editar/{idprov}")
	public String editarprov(@PathVariable int idprov,Model model) {
		Optional<Proveedor>proveedores=proveedorservicio.listarId(idprov);
		model.addAttribute("proveedores",proveedores);
		return "man_proveedor";
	}
	
	@GetMapping("/detalle_proveedor/{idprov}")
	public String detalleProveedor(@PathVariable int idprov,Model model, RedirectAttributes attribute) {
		Proveedor proveedor = null;
		if(idprov >0) {
			proveedor=proveedorservicio.buscarporId(idprov);
			if(proveedor==null) {
				attribute.addFlashAttribute("error","atencion: El id del proveedor no existe!");
				return "redirect:/listadoproveedor";
			}
		
		}else {
			attribute.addFlashAttribute("error","atencion: Error con el id del proveedor!");
			return "redirect:/listadoproveedor";
		}
		
		
		model.addAttribute("titulo","Detalle del Proveedor:"+proveedor.getNomprove());
		model.addAttribute("proveedor",proveedor);
		return "detalleProveedor";
	}

}
