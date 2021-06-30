package com.cts.microservice.service;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.microservice.model.CartDetails;
import com.cts.microservice.model.Coupon;
import com.cts.microservice.model.Product;
import com.cts.microservice.proxy.CouponServiceProxy;
import com.cts.microservice.proxy.ProductServiceProxy;
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Autowired
	CouponServiceProxy couponService;
	
	@Autowired
	ProductServiceProxy productService;
	
	
	@Value("${PRODUCT_SERVICE_URI}")
	private String productServiceUri;
	
	@Value("${COUPON_SERVICE_URI}")
	private String couponServiceUri;
	

	@Override
	public CartDetails getCartDetails(String productCode, String couponCode) {
//		Product product= getProductDetails(productCode);
//		Coupon coupon=getCouponDetails(couponCode);
		
		Product product=productService.getProduct(productCode);
		Coupon coupon=couponService.getCoupon(couponCode);
		
		
		
		
		CartDetails cartDetails=new CartDetails();
		cartDetails.setProduct(product);
		cartDetails.setCoupon(coupon);
		
		double couponDiscount=0;
		
		
		if(coupon.getValidTill().isAfter(LocalDate.now())) {
		
			if(product.getPrice()>=coupon.getMinCartValue()) {
				couponDiscount=(coupon.getDiscounts()/100)*product.getPrice();
				couponDiscount=Math.min(couponDiscount, coupon.getMaxDiscount());
			}
			
		}
		
		double finalPrice=product.getPrice()-couponDiscount;
		
		cartDetails.setCouponDiscount(couponDiscount);
		cartDetails.setFinalPrice(finalPrice);
		
		return cartDetails;
		
	}
	
	
	private Product getProductDetails(String productCode) {
		Product product=restTemplate.getForObject(productServiceUri+productCode, Product.class);
		return product;
	}
	
	private Coupon getCouponDetails(String couponCode) {
		Coupon coupon=restTemplate.getForObject(couponServiceUri+couponCode, Coupon.class);
		return coupon;
	}
	
	

}
