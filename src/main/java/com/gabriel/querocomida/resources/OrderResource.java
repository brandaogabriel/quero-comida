package com.gabriel.querocomida.resources;

import com.gabriel.querocomida.dtos.OrderDTO;
import com.gabriel.querocomida.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {
		List<OrderDTO> ordersDto = this.service.findAll();
		return ResponseEntity.ok().body(ordersDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
		OrderDTO orderDTO = this.service.findById(id);
		return ResponseEntity.ok().body(orderDTO);
	}
}
