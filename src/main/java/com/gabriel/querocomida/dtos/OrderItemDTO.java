package com.gabriel.querocomida.dtos;

import com.gabriel.querocomida.entities.OrderItem;

import java.io.Serializable;

public class OrderItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long orderId;
	private Long productId;
	private Integer quantity;
	private Double price;

	public OrderItemDTO() {
	}

	public OrderItemDTO(Long orderId, Long productId, Integer quantity, Double price) {
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderItemDTO(OrderItem entity) {
		this.orderId = entity.getOrder().getId();
		this.productId = entity.getProduct().getId();
		this.quantity = entity.getQuantity();
		this.price = entity.getPrice();
	}

	public Long getOrderId() {
		return orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}

