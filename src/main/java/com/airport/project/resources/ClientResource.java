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

import com.airport.project.DTO.ClientDTO;
import com.airport.project.entities.Client;
import com.airport.project.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	ClientService service;	
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll(){
		List<Client> obj = service.findAll();
		List<ClientDTO> dto = new ArrayList<>();
		for(Client x : obj) {
			ClientDTO dto2 = new ClientDTO(); dto2=dto2.transformaEmDTO(x);
			dto.add(dto2);
		}
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody ClientDTO obj){
		Client objc = obj.transformaEmObjeto(obj);
		service.insert(objc);
		return new ResponseEntity<Client>(objc, HttpStatus.CREATED);
	}
	
}
