package com.airport.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airport.project.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

}
