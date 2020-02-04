package com.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entities.Order;
import com.course.repository.OrderRepository;
import com.course.service.exception.ObjectNotFound;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> listAll(){
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		if (!order.isPresent()) {
			throw new ObjectNotFound("Objeto não encontrado");
		}
		return order.get();
	}
}
