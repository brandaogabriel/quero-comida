package com.gabriel.querocomida.services;

import com.gabriel.querocomida.dtos.UserDTO;
import com.gabriel.querocomida.entities.User;
import com.gabriel.querocomida.repositories.UserRepository;
import com.gabriel.querocomida.services.exceptions.ResourceNotFoundException;
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
		User user = obj.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		return new UserDTO(user);
	}

	@Transactional
	public UserDTO insert(UserDTO userDTO) {
		User user = new User();
		copyToDto(user, userDTO);
		user = this.repository.save(user);
		return new UserDTO(user);
	}

	private void copyToDto(User user, UserDTO userDTO) {
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setPassword(userDTO.getPassword());
	}

	@Transactional
	public UserDTO update(Long id, UserDTO userDTO) {
		User user = this.repository.getOne(id);
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user = this.repository.save(user);
		return new UserDTO(user);
	}

	@Transactional
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
