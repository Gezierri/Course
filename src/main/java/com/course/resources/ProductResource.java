package com.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entities.Product;
import com.course.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private  ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> listAll() {
		List<Product> product = productService.findAll();
		return ResponseEntity.ok().body(product);
	}
}
