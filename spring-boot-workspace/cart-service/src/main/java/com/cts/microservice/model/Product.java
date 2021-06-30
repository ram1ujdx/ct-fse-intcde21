package com.cts.microservice.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {


	
	private String productCode;
	
	
	private String productName;
	
	private double price;
	
	
}
