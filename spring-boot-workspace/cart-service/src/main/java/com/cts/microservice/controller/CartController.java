package com.cts.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.microservice.model.CartDetails;
import com.cts.microservice.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService service;
	
	@GetMapping("/product-code/{productCode}/coupon-code/{couponCode}")
	public CartDetails getCartDetails(@PathVariable String productCode, @PathVariable String couponCode) {
		return service.getCartDetails(productCode, couponCode);
	}
	
}
