package com.cts.microservice.service;

import com.cts.microservice.model.Coupon;

public interface CouponService {

	public Coupon getCouponByCouponCode(String couponCode);
	
	public Coupon addCoupon(Coupon coupon);
}
