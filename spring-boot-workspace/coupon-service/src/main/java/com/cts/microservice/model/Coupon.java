package com.cts.microservice.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {

	@Id @GeneratedValue
	private long id;
	private String couponCode;
	private double discounts;
	private double maxDiscount;
	private double minCartValue;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate validTill;
	
}
