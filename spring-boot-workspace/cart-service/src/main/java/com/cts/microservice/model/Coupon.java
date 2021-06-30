package com.cts.microservice.model;

import java.time.LocalDate;



import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {

	private String couponCode;
	private double discounts;
	private double maxDiscount;
	private double minCartValue;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate validTill;
	
}
