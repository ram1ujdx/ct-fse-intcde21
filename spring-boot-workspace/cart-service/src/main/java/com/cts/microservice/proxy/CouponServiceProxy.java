package com.cts.microservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.microservice.model.Coupon;
import com.cts.microservice.model.Product;

@FeignClient(value = "coupon-service", name = "coupon-service")
public interface CouponServiceProxy {

	@GetMapping("/coupons/coupon-code/{couponCode}")
	Coupon getCoupon(@PathVariable String couponCode) ;
	
}
