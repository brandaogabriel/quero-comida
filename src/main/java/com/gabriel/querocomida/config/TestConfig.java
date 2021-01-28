package com.gabriel.querocomida.config;

import com.gabriel.querocomida.entities.User;
import com.gabriel.querocomida.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void saveUsers() {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		this.userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
