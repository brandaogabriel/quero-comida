package com.gabriel.querocomida.dtos;

import com.gabriel.querocomida.entities.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long Id;
	private String name;
	private String email;
	private String phone;
	private String password;

	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email, String phone, String password) {
		this.Id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public UserDTO(User entity) {
		this.Id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();
		this.password = entity.getPassword();
	}

	public Long getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
