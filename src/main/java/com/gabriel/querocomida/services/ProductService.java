package com.gabriel.querocomida.services;

import com.gabriel.querocomida.dtos.ProductDTO;
import com.gabriel.querocomida.entities.Product;
import com.gabriel.querocomida.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> products = this.repository.findAll();
		return products.stream().map(ProductDTO::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> obj = this.repository.findById(id);
		return new ProductDTO(obj.get());
	}

}
