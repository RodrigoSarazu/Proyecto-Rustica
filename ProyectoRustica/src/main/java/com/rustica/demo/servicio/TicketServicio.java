package com.rustica.demo.servicio;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rustica.demo.InterfacesServicios.TicketInterfaceServicio;
import com.rustica.demo.interfaces.TicketInterface;
import com.rustica.demo.modelo.Ticket;

@Service
public class TicketServicio implements TicketInterfaceServicio{

	@Autowired
	TicketInterface data;
	
	
	@Override
	public List<Ticket> listar() {
		return (List<Ticket>)data.findAll();
	}

	@Override
	public int save(Ticket p) {
		int res = 0;
		Ticket ticket = data.save(p);
		if(!ticket.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int idticket) {
		data.deleteById(idticket);
	}


	@Override
	public List<Ticket> buscarPorTicket(int idticket) {		
		return data.findById(idticket);
	}

	


}
