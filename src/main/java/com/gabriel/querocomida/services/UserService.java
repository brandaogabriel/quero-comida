package com.gabriel.querocomida.services;

import com.gabriel.querocomida.dtos.UserDTO;
import com.gabriel.querocomida.entities.User;
import com.gabriel.querocomida.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> users = this.repository.findAll();
		return users.stream().map(UserDTO::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = this.repository.findById(id);
		return new UserDTO(obj.get());
	}
}
