package com.airport.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.project.entities.Ticket;
import com.airport.project.repositories.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository flightRepository;
	
	public List<Ticket> findAll(){
		return flightRepository.findAll();
	}
	
	public Ticket insert(Ticket obj) {
		return flightRepository.save(obj);
	}
}
