package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
