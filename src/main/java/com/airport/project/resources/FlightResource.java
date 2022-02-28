package com.airport.project.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.airport.project.DTO.FlightDTO;
import com.airport.project.entities.Flight;
import com.airport.project.service.FlightService;

@RestController
@RequestMapping(value = "/flight")
public class FlightResource {
	
	@Autowired
	FlightService service;	
	
	@GetMapping
	public ResponseEntity<List<FlightDTO>> findAll(){
		List<Flight> obj = service.findAll();
		List<FlightDTO> dto = new ArrayList<>();
		for(Flight x : obj) {
			FlightDTO dto2 = new FlightDTO(); dto2=dto2.transformaEmDTO(x);
			dto.add(dto2);
		}
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<Flight> insert(@RequestBody FlightDTO obj){
		Flight objf = obj.transformaEmObjeto(obj);
		service.insert(objf);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		return ResponseEntity.created(uri).body(objf);
	}
	
}
