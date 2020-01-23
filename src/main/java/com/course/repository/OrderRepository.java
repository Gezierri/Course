package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
