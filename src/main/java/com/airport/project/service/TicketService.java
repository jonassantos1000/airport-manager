package com.airport.project.service;

import java.util.List;
import java.util.Optional;

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

	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	public Ticket findById(Long id) {
		Optional<Ticket> obj = ticketRepository.findById(id);
		return obj.get();
	}

	public Ticket insert(Ticket obj) {
		obj.setFlight(customRepository.findSeatAvailable(obj.getFlight().getId()));
		obj.setClient(customRepository.validClient(obj.getClient().getId()));
		if (obj.getClient() == null) {
			throw new com.airport.project.service.exceptions.ResourceNotFoundException("Client invalid");
		} else if (obj.getFlight() == null) {
			throw new com.airport.project.service.exceptions.ResourceNotFoundException("Flight invalid");
		} else if (validSeat(obj) == false) {
			throw new com.airport.project.service.exceptions.IllegalArgumentException(
					"Seat unavailable " + obj.getAssento());
		} else {
			ticketRepository.save(obj);
			return obj = findById(obj.getId());
		}
	}

	public boolean validSeat(Ticket obj) {
		if (obj.getFlight().getQtde_assento_disponivel() < 1) {
			throw new com.airport.project.service.exceptions.IllegalArgumentException(
					"All seats are sold out");
		}

		for (String x : obj.getFlight().getListAssentosDisponiveis()) {
			if (obj.getAssento() == Integer.valueOf(x)) {
				return true;
			}
		}
		return false;

	}

}
