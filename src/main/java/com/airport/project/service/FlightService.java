package com.airport.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.project.entities.Flight;
import com.airport.project.repositories.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	public Flight insert(Flight obj) {
		return flightRepository.save(obj);
	}
}
