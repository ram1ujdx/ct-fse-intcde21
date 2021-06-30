package com.cts.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetails {

	private Product product;
	
	private Coupon coupon;
	
	private double finalPrice;
	private double couponDiscount;
	
	
	
	
}
