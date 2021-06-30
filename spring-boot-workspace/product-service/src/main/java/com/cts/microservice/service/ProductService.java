package com.cts.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cts.microservice.model.Product;

public interface ProductService {


	
	public Product getProductByProductCode(String productCode) ;
	
	public Product addProduct(Product product);
}
