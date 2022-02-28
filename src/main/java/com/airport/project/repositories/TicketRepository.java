package com.airport.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airport.project.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	
}
