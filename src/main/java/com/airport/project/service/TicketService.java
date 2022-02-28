package com.airport.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.project.entities.Ticket;
import com.airport.project.repositories.TicketCustomRepository;
import com.airport.project.repositories.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	TicketCustomRepository customRepository;
	
	public List<Ticket> findAll(){
		return ticketRepository.findAll();
	}
	
	public Ticket insert(Ticket obj) {
		obj.setFlight(customRepository.findSeatAvailable(obj.getFlight().getId()));
		if(obj.getAssento() > obj.getFlight().getQtde_assento_disponivel()) {
			throw new com.airport.project.service.exceptions.IllegalArgumentException("Seat unavailable "+ obj.getAssento());
		}else {
			return ticketRepository.save(obj);
		}
		
	}
}
