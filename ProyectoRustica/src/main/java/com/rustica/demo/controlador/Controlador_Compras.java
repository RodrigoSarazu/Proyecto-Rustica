package com.rustica.demo.controlador;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rustica.demo.modelo.Compras;
import com.rustica.demo.modelo.Proveedor;
import com.rustica.demo.servicio.ComprasServicio;
import com.rustica.demo.servicio.ProveedorServicio;

@Controller
@RequestMapping
public class Controlador_Compras {
	
	@Autowired
	private ComprasServicio comprasservicio;
	
	@Autowired
	private ProveedorServicio proveedorservicio;
	
	@GetMapping("/listadocompras")
	public String comprasadmin(Model model){
		List<Compras>comprasadmin=comprasservicio.listar();
		model.addAttribute("comprasadmin",comprasadmin);
		return "listadocompras";
	}
	
	@GetMapping("/mant_compras")
	public String agregarcompras(Model model) {
		Compras comprasadmin=new Compras();
		List<Proveedor>listproveedor=proveedorservicio.listar();
		model.addAttribute("comprasadmin",comprasadmin);
		model.addAttribute("proveedor",listproveedor);
		return "mant_compras";
	}
	
	@PostMapping("/save_compra")
	public String savecompras(@ModelAttribute Compras compras, Model model,RedirectAttributes attribute,BindingResult result) {
		List<Proveedor>listproveedor=proveedorservicio.listar();
		if(result.hasErrors()) {
		model.addAttribute("comprasadmin",compras);
		model.addAttribute("proveedor",listproveedor);
		System.out.println("Existieron errores en el formulario");			
		return "mant_compras";
		}
		comprasservicio.save(compras);
		System.out.println("La compra se guardo con exito!");
		attribute.addFlashAttribute("success", "Compra guardada con exito!");
		return "redirect:/listadocompras";
	}
	
	 @GetMapping("/editar_compra/{idcomp}")
	 public String editarcompraadmin(@PathVariable int idcomp, Model model, RedirectAttributes attribute) {
		 
		Compras compras = null;
		
		if(idcomp > 0) {
			compras = comprasservicio.buscarPorId(idcomp);
			
			if(compras == null) {
				System.out.println("Error: El id de compra no existe!");
				attribute.addFlashAttribute("error", "Atencion: el id de compra no existe");
				return "redirect:/listadocompras";
			}
		}else {
			System.out.println("Error: error con el id de compra");
			attribute.addFlashAttribute("error","Atencion: Error con el id de compra");
			return "redirect:/listadocompras";
		}		 
		List<Proveedor>listproveedor=proveedorservicio.listar();
		model.addAttribute("comprasadmin",compras);
		model.addAttribute("proveedor",listproveedor);
		return "mant_compras";
	}
	 
	 

	@GetMapping("/eliminar_compra/{idcomp}")
	public String eliminarcompraadmin(@PathVariable int idcomp, Model model, RedirectAttributes attribute) {
		comprasservicio.delete(idcomp);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
		return "redirect:/listadocompras";
	}
	

	@GetMapping("/detalle_compras/{idcomp}")
	public String detalleCompra(@PathVariable int idcomp,Model model, RedirectAttributes attribute) {
		Compras compras  = null;
		if(idcomp >0) {
			compras=comprasservicio.buscarPorId(idcomp);
			if(compras==null) {
				attribute.addFlashAttribute("error","atencion:El id del compras no existe!");
				return "redirect:/listadocompras";
			}
		
		}else {
			attribute.addFlashAttribute("error","atencion: Error con el id del compras!");
			return "redirect:/listadocompras";
		}
		
		
		model.addAttribute("titulo","Detalle del Compras:"+compras.getDescripcion());
		model.addAttribute("compras",compras);
		return "detalleCompras";
	}

}
