package com.gabriel.querocomida.dtos;

import com.gabriel.querocomida.entities.Order;
import com.gabriel.querocomida.entities.enums.OrderStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant moment;
	private OrderStatus orderStatus;
	private UserDTO client;
	private List<OrderItemDTO> items = new ArrayList<>();

	public OrderDTO() {
	}

	public OrderDTO(Long id, Instant moment, OrderStatus orderStatus, UserDTO client) {
		this.id = id;
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	}

	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.orderStatus = entity.getOrderStatus();
		this.client = new UserDTO(entity.getClient());
		entity.getItems().forEach(orderItem -> this.items.add(new OrderItemDTO(orderItem)));
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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public UserDTO getClient() {
		return client;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}
}
