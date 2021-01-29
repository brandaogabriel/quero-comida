package com.gabriel.querocomida.services;

import com.gabriel.querocomida.dtos.CategoryDTO;
import com.gabriel.querocomida.entities.Category;
import com.gabriel.querocomida.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> categories = this.repository.findAll();
		return categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = this.repository.findById(id);
		return new CategoryDTO(obj.get());
	}

}
