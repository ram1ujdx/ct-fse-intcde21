package com.cts.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.microservice.model.Product;
import com.cts.microservice.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo repo;
	
	@Override
	public Product getProductByProductCode(String productCode) {
		return repo.findProductByProductCode(productCode);
	}

	@Override
	public Product addProduct(Product product) {
		return repo.save(product);
	}

}
