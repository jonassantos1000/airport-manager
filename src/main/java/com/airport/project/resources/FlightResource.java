package com.airport.project.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.airport.project.entities.Flight;
import com.airport.project.service.FlightService;

@RestController
@RequestMapping(value = "/flight")
public class FlightResource {
	
	@Autowired
	FlightService service;	
	
	@GetMapping
	public ResponseEntity<List<Flight>> findAll(){
		List<Flight> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Flight> insert(@RequestBody Flight obj){
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
