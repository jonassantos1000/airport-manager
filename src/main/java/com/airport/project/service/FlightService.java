package com.airport.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.project.entities.Flight;
import com.airport.project.repositories.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	public List<Flight> findAll(){
		return flightRepository.findAll();
	}
	
	public Flight insert(Flight obj) {
		return flightRepository.save(obj);
	}
}
