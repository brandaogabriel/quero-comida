package com.gabriel.querocomida.config;

import com.gabriel.querocomida.entities.Order;
import com.gabriel.querocomida.entities.User;
import com.gabriel.querocomida.entities.enums.OrderStatus;
import com.gabriel.querocomida.repositories.OrderRepository;
import com.gabriel.querocomida.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@PostConstruct
	public void createSeed() {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2020-06-20T19:53:07Z"), OrderStatus.PAID,u1);
		Order o2 = new Order(null, Instant.parse("2020-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,u2);
		Order o3 = new Order(null, Instant.parse("2020-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);

		this.userRepository.saveAll(Arrays.asList(u1, u2));
		this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
