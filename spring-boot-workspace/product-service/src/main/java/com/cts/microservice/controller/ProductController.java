package com.cts.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.microservice.model.Product;
import com.cts.microservice.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/product-code/{productCode}")
	public Product getProduct(@PathVariable String productCode) {
		return service.getProductByProductCode(productCode);
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
}
