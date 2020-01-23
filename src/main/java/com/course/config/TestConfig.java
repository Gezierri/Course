package com.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.entities.Order;
import com.course.entities.User;
import com.course.entities.enums.OrderStatus;
import com.course.repository.OrderRepository;
import com.course.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {

		User maria = new User(null, "Maira", "maria@gmail.com", "909346", "12345");
		User pedro = new User(null, "Pedro", "pedro@gmail.com", "4312758", "23456");
		
		Order pedido1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), maria, OrderStatus.DELIVERED);
		Order pedido2 = new Order(null, Instant.parse("2019-07-21T03:42:17Z"), pedro, OrderStatus.PAID);
		Order pedido3 = new Order(null, Instant.parse("2019-06-22T23:53:22Z"), maria, OrderStatus.WAITING_PAYMENT);
		
		userRepository.saveAll(Arrays.asList(maria, pedro));
		orderRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
	}

}
