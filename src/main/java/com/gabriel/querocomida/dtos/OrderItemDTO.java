package com.gabriel.querocomida.dtos;

import com.gabriel.querocomida.entities.OrderItem;

import java.io.Serializable;

public class OrderItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private ProductDTO product;
	private Integer quantity;
	private Double price;

	public OrderItemDTO() {
	}

	public OrderItemDTO(ProductDTO productDTO, Integer quantity, Double price) {
		this.product = productDTO;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderItemDTO(OrderItem entity) {
		this.product = new ProductDTO(entity.getProduct());
		this.quantity = entity.getQuantity();
		this.price = entity.getPrice();
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO productDTO) {
		this.product = productDTO;
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

