package com.airport.project.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airport.project.DTO.TicketDTO;
import com.airport.project.entities.Ticket;
import com.airport.project.service.TicketService;

@RestController
@RequestMapping(value = "/ticket")
public class TicketResource {
	
	@Autowired
	TicketService service;	
	
	@GetMapping
	public ResponseEntity<List<TicketDTO>> findAll(){
		List<Ticket> obj = service.findAll();
		List<TicketDTO> dto = new ArrayList<>();
		for(Ticket x : obj) {
			TicketDTO dto2 = new TicketDTO(); dto2=dto2.transformaEmDTO(x);
			dto.add(dto2);
		}
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<TicketDTO> insert(@RequestBody TicketDTO obj){
		Ticket objc = obj.transformaEmObjeto(obj);
		objc=service.insert(objc);
		TicketDTO dto = new TicketDTO();
		dto=dto.transformaEmDTO(objc);
		return new ResponseEntity<TicketDTO>(dto, HttpStatus.CREATED);
	}
	
}
