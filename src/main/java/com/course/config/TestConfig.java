package com.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.entities.Category;
import com.course.entities.Order;
import com.course.entities.OrderItem;
import com.course.entities.Product;
import com.course.entities.User;
import com.course.entities.enums.OrderStatus;
import com.course.repository.CategoryRepository;
import com.course.repository.OrderItemRepository;
import com.course.repository.OrderRepository;
import com.course.repository.ProductRepository;
import com.course.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

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
	
	@Override
	public void run(String... args) throws Exception {

		User maria = new User(null, "Maira", "maria@gmail.com", "909346", "12345");
		User pedro = new User(null, "Pedro", "pedro@gmail.com", "4312758", "23456");
		
		Order pedido1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), maria, OrderStatus.DELIVERED);
		Order pedido2 = new Order(null, Instant.parse("2019-07-21T03:42:17Z"), pedro, OrderStatus.PAID);
		Order pedido3 = new Order(null, Instant.parse("2019-06-22T23:53:22Z"), maria, OrderStatus.WAITING_PAYMENT);
		
		Category categoria1 = new Category(null, "Eletronics");
		Category categoria2 = new Category(null, "Books");
		Category categoria3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		categoryRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		
		p1.getCategories().add(categoria2);
		p2.getCategories().add(categoria1);
		p2.getCategories().add(categoria3);
		p3.getCategories().add(categoria3);
		p4.getCategories().add(categoria3);
		p5.getCategories().add(categoria2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		userRepository.saveAll(Arrays.asList(maria, pedro));
		orderRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
		OrderItem oi1 = new OrderItem(pedido1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(pedido1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(pedido2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(pedido3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
	}

}
