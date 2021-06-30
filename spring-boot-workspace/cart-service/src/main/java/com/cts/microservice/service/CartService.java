package com.cts.microservice.service;

import com.cts.microservice.model.CartDetails;

public interface CartService {

	public CartDetails getCartDetails(String productCode, String couponCode);
	
	
}
