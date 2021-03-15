package com.rustica.demo.interfaces;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rustica.demo.modelo.Ticket;


public interface TicketInterface extends CrudRepository<Ticket, Integer>{
	List<Ticket> findById(int idticket);
}
