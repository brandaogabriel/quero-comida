package com.gabriel.querocomida.resources;

import com.gabriel.querocomida.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<UserDTO> findAll() {
			UserDTO userDto = new UserDTO(1L, "Gabriel", "gabriel@admin","12345678",
					"123");
			return ResponseEntity.ok().body(userDto);
	}
}
