package com.cts.microservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.microservice.model.Coupon;
import com.cts.microservice.service.CouponService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/coupons")
@Slf4j
public class CouponController {

	@Autowired
	CouponService service;
	
	@GetMapping("/coupon-code/{couponCode}")
	public Coupon getCoupon(@PathVariable String couponCode, HttpServletRequest request) {
		String headerText=request.getHeader("auth");
		log.info(headerText);
		
		return service.getCouponByCouponCode(couponCode);
	}
	
	@PostMapping
	public Coupon addCoupon(@RequestBody Coupon coupon) {
		return service.addCoupon(coupon);
	}
	
	
}
