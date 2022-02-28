package com.airport.project.DTO;

import java.util.HashSet;
import java.util.Set;

import com.airport.project.entities.Client;
import com.airport.project.entities.Ticket;

public class ClientDTO {

	private Long id;
	private String name;
	private Set<Ticket> tickets = new HashSet<>();

	
	public ClientDTO() {
		super();
	}
	public ClientDTO(Long id, String name, Set<Ticket> tickets) {
		super();
		this.id = id;
		this.name = name;
		this.tickets = tickets;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public ClientDTO transformaEmDTO(Client client) {
		return new ClientDTO(client.getId(),client.getNome(),client.getTickets());
	}
	
	public Client transformaEmObjeto(ClientDTO client) {
		return new Client(client.getId(),client.getName());
	}
	
}
