package com.rustica.demo.InterfacesServicios;

import java.util.List; 


import org.springframework.stereotype.Repository;


import com.rustica.demo.modelo.Ticket;

@Repository
public interface TicketInterfaceServicio {
	List<Ticket>buscarPorTicket(int idticket);
	public List<Ticket>listar();
	public int save (Ticket p);
	public void delete(int idticket);
	

}
