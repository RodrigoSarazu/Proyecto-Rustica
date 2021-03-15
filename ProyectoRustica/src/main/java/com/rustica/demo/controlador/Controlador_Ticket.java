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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rustica.demo.modelo.Comida;
import com.rustica.demo.modelo.Ticket;
import com.rustica.demo.servicio.ComidaServicio;
import com.rustica.demo.servicio.TicketServicio;

@Controller
@RequestMapping
public class Controlador_Ticket {
	
	@Autowired
	private TicketServicio ticketservicio;
	
	@Autowired
	private ComidaServicio comidaservicio;
	
	@GetMapping("/vista_tickets")
	public String ticketform(Model model) {
		model.addAttribute("ticket",new Ticket());
		return "vista_tickets";
	}
	
	@GetMapping("/idticket")
    public String buscarPorCliente(@RequestParam int idticket,Model model, @ModelAttribute("ticket")Ticket ticket) {
        model.addAttribute("ticketPorUsuario",ticketservicio.buscarPorTicket(idticket));
        return "vista_tickets";
    }
	
	@GetMapping("/listadoticket")
	public String listarticket(Model model) {
		List<Ticket>tickets= ticketservicio.listar();
		model.addAttribute("tickets",tickets);
		return "listadoticket";
	}
	
	@GetMapping("/man_ticket")
	public String agregarticket(Model model){
		List<Comida>listcomida=comidaservicio.listar();
		model.addAttribute("nombre",listcomida);
		model.addAttribute("tickets",new Ticket());
		return "man_ticket";
	}
	
	
	@PostMapping("/save_ticket")
	public String save( @ModelAttribute Ticket p, Model model, RedirectAttributes attribute,BindingResult result) {
		List<Comida>listcomida=comidaservicio.listar();
		if(result.hasErrors()) {
		model.addAttribute("listadoticket",p);
		model.addAttribute("nombre",listcomida);
		System.out.println("Existieron errores en el formulario");			
		return "man_ticket";
		}
		ticketservicio.save(p);
		System.out.println("El ticket se guardo con exito!");
		attribute.addFlashAttribute("success", "Ticket guardado con exito!");
		return "redirect:/listadoticket";
	}
	
	
	@GetMapping("/ticket_eliminar/{idticket}")
	public String eliminarticket(Model model, @PathVariable int idticket, RedirectAttributes attribute) {
		ticketservicio.delete(idticket);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
		return "redirect:/listadoticket";
	}

}
