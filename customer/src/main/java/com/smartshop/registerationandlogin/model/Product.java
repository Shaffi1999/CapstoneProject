package com.smartshop.registerationandlogin.model;

import java.util.List;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
	@Id
	private int id;
	private String productName;
	private long price;
	private int stockCount;
	
	List<Product> products;
	
	

//	private String brand;
//	private String type;
//	private String quantityType;
//	private long ratePerQuantity;
//	private int stockCount;

}
