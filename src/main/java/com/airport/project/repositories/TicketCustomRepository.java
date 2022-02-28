package com.airport.project.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.airport.project.entities.Client;
import com.airport.project.entities.Flight;
import com.airport.project.entities.Ticket;

@Repository
@Transactional
public class TicketCustomRepository {

	public TicketCustomRepository(EntityManager em) {
		super();
		this.em = em;
	}

	private final EntityManager em;

	public Flight findSeatAvailable(Long id) {
		try {
			String SQLSELECTCODIGO = "SELECT * FROM FLIGHT WHERE ID= :id";
			Query q = em.createNativeQuery(SQLSELECTCODIGO, Flight.class);
			q.setParameter("id", id);
			List<Flight> listObj = q.getResultList();
			Flight obj = listObj.get(0);
			return obj;
		}catch(Exception e) {
			return null;
		}
	}
	
	public Client validClient(Long id) {
		try {
			String SQLSELECTCODIGO = "SELECT * FROM CLIENT WHERE id = :id";
			Query q = em.createNativeQuery(SQLSELECTCODIGO, Client.class);
			q.setParameter("id", id);
			List<Client> listObj = q.getResultList();
			Client obj = listObj.get(0);
			return obj;
		}catch(Exception e) {
			return null;
		}
	}

}
