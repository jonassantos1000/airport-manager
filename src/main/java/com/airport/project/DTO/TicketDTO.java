package com.airport.project.DTO;

import java.time.Instant;

import com.airport.project.entities.Client;
import com.airport.project.entities.Flight;
import com.airport.project.entities.Ticket;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TicketDTO {

	private Long id;
	private Flight flight;
	private Integer assento;
	private Client client;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
	private Instant data_compra;
		
	public TicketDTO() {
		super();
	}
			
	public TicketDTO(Long id, Flight flight, Integer assento, Client client, Instant data_compra) {
		super();
		this.id = id;
		this.flight = flight;
		this.assento = assento;
		this.client = client;
		this.data_compra = data_compra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Integer getAssento() {
		return assento;
	}

	public void setAssento(Integer assento) {
		this.assento = assento;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Instant getData_compra() {
		return data_compra;
	}

	public void setData_compra(Instant data_compra) {
		this.data_compra = data_compra;
	}

	public TicketDTO transformaEmDTO(Ticket ticket) {
		return new TicketDTO(ticket.getId(),ticket.getFlight(),ticket.getAssento(),ticket.getClient(),ticket.getData_compra());
	}
	
	public Ticket transformaEmObjeto(TicketDTO ticket) {
		return new Ticket(ticket.getId(),ticket.getFlight(),ticket.getAssento(),ticket.getClient(),ticket.data_compra);
	}
	
}
