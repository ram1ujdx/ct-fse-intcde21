package com.cts.microservice.service;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.microservice.model.Coupon;
import com.cts.microservice.repo.CouponRepo;

@Service
public class CouponServiceImpl implements CouponService {
	

	@Autowired
	private CouponRepo repo;
	
	@PostConstruct
	public void init() {
		Coupon coupon1=new Coupon(0, "c1001", 12.5, 500, 5000, LocalDate.of(2021, 8, 30));
		Coupon coupon2=new Coupon(0, "c1002", 18.5, 1000, 9000, LocalDate.of(2021, 9, 30));
		
		repo.save(coupon1);
		repo.save(coupon2);
		
	}
	

	
	@Override
	public Coupon getCouponByCouponCode(String couponCode) {
		return repo.findByCouponCode(couponCode);
	}

	@Override
	public Coupon addCoupon(Coupon coupon) {
		return repo.save(coupon);
	}

	
	
	
}
