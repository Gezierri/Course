package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
