package com.cts.microservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.microservice.model.Product;

@FeignClient(value = "product-service", name = "product-service")
public interface ProductServiceProxy {

	@GetMapping("/products/product-code/{productCode}")
	Product getProduct(@PathVariable String productCode) ;
	
}
