package com.cts.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.microservice.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	
	Product findProductByProductCode(String productCode);

}
