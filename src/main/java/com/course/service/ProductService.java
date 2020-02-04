package com.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entities.Product;
import com.course.repository.ProductRepository;
import com.course.service.exception.ObjectNotFound;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (!product.isPresent()) {
			throw new ObjectNotFound("Objeto não encontrado");
		}
		return product.get();
	}

}
