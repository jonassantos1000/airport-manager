package com.airport.project.DTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.airport.project.entities.Flight;
import com.airport.project.entities.Ticket;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FlightDTO {
	
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
	private Instant horario_saida;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
	private Instant horario_chegada;
	private String Origem;
	private String Destino;
	private Integer qtde_assento_total=0;
	private Double preço_passagem;
	private Integer qtde_assento_disponivel=0;
	private String assentos_disponiveis;
	
	private List<Ticket> tickets = new ArrayList<>();

	public FlightDTO() {
		super();
	}
	
	public FlightDTO(Long id, Instant horario_saida, Instant horario_chegada, String origem, String destino,
			Integer qtde_assento_total, Double preço_passagem, Integer qtde_assento_disponivel,
			String assentos_disponiveis, List<Ticket> tickets) {
		super();
		this.id = id;
		this.horario_saida = horario_saida;
		this.horario_chegada = horario_chegada;
		Origem = origem;
		Destino = destino;
		this.qtde_assento_total = qtde_assento_total;
		this.preço_passagem = preço_passagem;
		this.qtde_assento_disponivel = qtde_assento_disponivel;
		this.assentos_disponiveis = assentos_disponiveis;
		this.tickets = tickets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getHorario_saida() {
		return horario_saida;
	}

	public void setHorario_saida(Instant horario_saida) {
		this.horario_saida = horario_saida;
	}

	public Instant getHorario_chegada() {
		return horario_chegada;
	}

	public void setHorario_chegada(Instant horario_chegada) {
		this.horario_chegada = horario_chegada;
	}

	public String getOrigem() {
		return Origem;
	}

	public void setOrigem(String origem) {
		Origem = origem;
	}

	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	public Integer getQtde_assento_total() {
		return qtde_assento_total;
	}

	public void setQtde_assento_total(Integer qtde_assento_total) {
		this.qtde_assento_total = qtde_assento_total;
	}

	public Double getPreço_passagem() {
		return preço_passagem;
	}

	public void setPreço_passagem(Double preço_passagem) {
		this.preço_passagem = preço_passagem;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
		
	public Integer getQtde_assento_disponivel() {
		return qtde_assento_disponivel;
	}

	public void setQtde_assento_disponivel(Integer qtde_assento_disponivel) {
		this.qtde_assento_disponivel = qtde_assento_disponivel;
	}

	public String getAssentos_disponiveis() {
		return assentos_disponiveis;
	}

	public void setAssentos_disponiveis(String assentos_disponiveis) {
		this.assentos_disponiveis = assentos_disponiveis;
	}

	public FlightDTO transformaEmDTO(Flight flight) {
		return new FlightDTO (flight.getId(),flight.getHorario_saida(),flight.getHorario_chegada(),flight.getOrigem(),flight.getDestino(),flight.getQtde_assento_total(),flight.getPreço_passagem(),flight.getQtde_assento_disponivel(),flight.getAssentosDisponiveis(),flight.getTickets());
	}
	
	public Flight transformaEmObjeto(FlightDTO flight) {
		return new Flight(flight.getId(), flight.getHorario_saida(),flight.getHorario_chegada(), flight.getOrigem(), flight.getDestino(), flight.getQtde_assento_total(),flight.getPreço_passagem());
	}
	
}
