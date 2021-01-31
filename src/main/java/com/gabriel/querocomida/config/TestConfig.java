package com.gabriel.querocomida.config;

import com.gabriel.querocomida.entities.*;
import com.gabriel.querocomida.entities.enums.OrderStatus;
import com.gabriel.querocomida.repositories.*;
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

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@PostConstruct
	public void createSeed() {
		Category cat1 = new Category(null, "Pizza");
		Category cat2 = new Category(null, "Lanche");
		Category cat3 = new Category(null, "Massa");

		Product p1 = new Product(null, "Pizza de Calabresa", "Pizza especial com molho do chef", 30.50, "");
		Product p2 = new Product(null, "Coxinha de Frango", "Coxinha de frango temperada com maionese", 2.30, "");
		Product p3 = new Product(null, "X-Frango", "X-Frango classico com frango desfiado e queijo do reino", 8.50, "");
		Product p4 = new Product(null, "Esfira de Carne", "Esfirra de carne com cream cheese", 1.99, "");
		Product p5 = new Product(null, "Hamburguer Classico", "Hamburguer classico com ovo e carne", 12.90, "");

		this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategories().add(cat1);
		p2.getCategories().add(cat2);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat2);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		this.productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2020-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2020-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2020-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		this.userRepository.saveAll(Arrays.asList(u1, u2));
		this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		this.orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Payment pay1 = new Payment(null, o1, Instant.parse("2020-06-20T21:00:00Z"));
		o1.setPayment(pay1);
		this.orderRepository.save(o1);
	}
}
