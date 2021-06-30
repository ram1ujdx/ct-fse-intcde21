package com.cts.microservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {

	@Id
	@Column(name="id")
	private long id;
	@Column(name="product_code")
	private String productCode;
	
	@Column(name = "product_name")
	private String productName;
	@Column(name="price")
	private double price;
	
	
}
