package com.gabriel.querocomida.resources;

import com.gabriel.querocomida.dtos.UserDTO;
import com.gabriel.querocomida.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> usersDto = this.service.findAll();
		return ResponseEntity.ok().body(usersDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		UserDTO userDTO = this.service.findById(id);
		return ResponseEntity.ok().body(userDTO);
	}
}
