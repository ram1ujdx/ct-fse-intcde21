package com.cts.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.microservice.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long>{
	
	Coupon findByCouponCode(String couponCode);

}
