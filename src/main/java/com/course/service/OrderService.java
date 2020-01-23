package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entities.Order;
import com.course.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> listAll(){
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
