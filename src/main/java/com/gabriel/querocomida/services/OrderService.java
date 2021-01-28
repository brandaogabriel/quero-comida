package com.gabriel.querocomida.services;

import com.gabriel.querocomida.dtos.OrderDTO;
import com.gabriel.querocomida.entities.Order;
import com.gabriel.querocomida.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> orders = this.repository.findAll();
		return orders.stream().map(OrderDTO::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Optional<Order> obj = this.repository.findById(id);
		return new OrderDTO(obj.get());
	}
}
