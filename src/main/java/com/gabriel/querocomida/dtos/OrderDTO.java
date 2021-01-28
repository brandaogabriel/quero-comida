package com.gabriel.querocomida.dtos;

import com.gabriel.querocomida.entities.Order;

import java.io.Serializable;
import java.time.Instant;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant moment;
	private UserDTO client;

	public OrderDTO() {
	}

	public OrderDTO(Long id, Instant moment, UserDTO client) {
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.client = new UserDTO(entity.getClient());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public UserDTO getClient() {
		return client;
	}

}
