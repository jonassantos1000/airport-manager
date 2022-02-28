package com.airport.project.repositories;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.airport.project.entities.Flight;

@Repository
@Transactional
public class TicketCustomRepository {

	public TicketCustomRepository(EntityManager em) {
		super();
		this.em = em;
	}

	private final EntityManager em;

	public Flight findSeatAvailable(Long id) {
		String SQLSELECTCODIGO = "SELECT * FROM FLIGHT WHERE ID= :id";
		Query q = em.createNativeQuery(SQLSELECTCODIGO, Flight.class);
		q.setParameter("id", id);
		Flight obj = (Flight) q.getResultList().get(0);
		return obj;
	}

}
