package com.airport.project.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Flight implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
	private Instant horario_saida;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
	private Instant horario_chegada;
	private String Origem;
	private String Destino;
	private Integer qtde_assento_total=0;
	private Double preço_passagem;
	
	@OneToMany(mappedBy = "flight")
	private List<Ticket> tickets = new ArrayList<>();
	
	public Flight() {
		
	}
	
	public Flight(Long id, Instant horario_saida, Instant horario_chegada, String origem, String destino,
		Integer qtde_assento_total, Double preço_passagem) {
		super();
		this.id = id;
		this.horario_saida = horario_saida;
		this.horario_chegada = horario_chegada;
		Origem = origem;
		Destino = destino;
		this.qtde_assento_total = qtde_assento_total;
		this.preço_passagem = preço_passagem;
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
	
	@JsonIgnore
	public Integer getQtde_assento_total() {
		return qtde_assento_total;
	}

	@JsonIgnore
	public void setQtde_assento_total(Integer qtde_assento_total) {
		this.qtde_assento_total = qtde_assento_total;
	}

	public Double getPreço_passagem() {
		return preço_passagem;
	}
	public void setPreço_passagem(Double preço_passagem) {
		this.preço_passagem = preço_passagem;
	}
		
	@JsonIgnore
	public Integer getQtde_assento_disponivel() {
		return qtde_assento_total - getTickets().size();
	}

	@JsonIgnore
	public List<Ticket> getTickets() {
		return tickets;
	}
	
	@JsonIgnore
	public String getAssentosDisponiveis() {
		List <String> Listassentos= new ArrayList<>();
		String assentos="";
		for (int i=1; i <= getQtde_assento_total(); i++) {
			Listassentos.add(String.valueOf(i));
			for (Ticket t : getTickets()) {
				if (t.getAssento().equals(i)) {
					Listassentos.remove(String.valueOf(t.getAssento()));
				}
			}
		}
		return assentos.join(",", Listassentos);
	}
	
	@Transient
	@JsonIgnore
	public List<String> getListAssentosDisponiveis() {
		List <String> Listassentos= new ArrayList<>();
		for (int i=1; i <= getQtde_assento_total(); i++) {
			Listassentos.add(String.valueOf(i));
			for (Ticket t : getTickets()) {
				if (t.getAssento().equals(i)) {
					Listassentos.remove(String.valueOf(t.getAssento()));
				}
			}
		}
		return Listassentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
