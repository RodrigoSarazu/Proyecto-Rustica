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

import com.rustica.demo.modelo.Domicilio;
import com.rustica.demo.modelo.Metodo_Pago;
import com.rustica.demo.modelo.Orden_Pago;
import com.rustica.demo.servicio.DomicilioServicio;
import com.rustica.demo.servicio.Metodo_PagoServicio;
import com.rustica.demo.servicio.Orden_PagoServicio;

@Controller
@RequestMapping
public class Controlador_OrdenPago {
	
	@Autowired
	private Orden_PagoServicio ordenpagoservicio;
	
	@Autowired
	private Metodo_PagoServicio metodopagoservicio;
	
	@Autowired
	private DomicilioServicio domicilioservicio;
	
	@GetMapping("/ordenpago")
	public String listarOrdenPago(Model model) {
		List<Orden_Pago>listaordenpago=ordenpagoservicio.listar();
		model.addAttribute("titulo","lista de orden de pago");
		model.addAttribute("listaordenpago",listaordenpago);
		return "ordenpago";
	}
	@GetMapping("/manOrdenPago")
	public String crearOrdenPago(Model model) {
		Orden_Pago ordenpago=new Orden_Pago();
		List<Metodo_Pago>listMetodopago=metodopagoservicio.listar();
		List<Domicilio>listdomicilio=domicilioservicio.listar();
		model.addAttribute("ordenpago",ordenpago);
		model.addAttribute("domicilio",listdomicilio);
		model.addAttribute("metodopago",listMetodopago);
		return "manOrdenPago";
	}
	@GetMapping("/detalle_ordenpago/{idord}")
	public String detalleOrdenPago(@PathVariable int idord,Model model, RedirectAttributes attribute) {
		Orden_Pago ordenpago = null;
		if(idord >0) {
			ordenpago=ordenpagoservicio.buscarPorId(idord);
			if(ordenpago==null) {
				attribute.addFlashAttribute("error","atencion:El id de la comida no existe!");
				return "redirect:/listadocomidaadmin";
			}
		
		}else {
			attribute.addFlashAttribute("error","atencion: Error con el id de la comida!");
			return "redirect:/listadocomidaadmin";
		}
		model.addAttribute("ordenpago",ordenpago);
		return "DetalleOrdenPago";
	}
	
	//aqui2
    @PostMapping("/save_pago")
    public String guardarOrdenPago( @ModelAttribute Orden_Pago o,Model model, RedirectAttributes attribute, BindingResult result) {
    	List<Metodo_Pago>listmetodo= metodopagoservicio.listar();
    	List<Domicilio>listdomicilio=domicilioservicio.listar();
    	if(result.hasErrors()) {
    	model.addAttribute("ordenpago",o);
    	model.addAttribute("metodopago",listmetodo);
    	model.addAttribute("domicilio",listdomicilio);
    	return "manOrdenPago";
    	}
    	ordenpagoservicio.guardar(o);
		System.out.println("El orden de pago se guardo con exito!");
		attribute.addFlashAttribute("success", "Orden de pago guardado con exito!");
    	return "redirect:/ordenpago";
    }
    
    @GetMapping("/ordenpago_eliminar/{idord}")
	public String eliminarOrdenPago(Model model, @PathVariable int idord, RedirectAttributes attribute) {
		ordenpagoservicio.eliminar(idord);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
		return "redirect:/ordenpago";
	}

}
