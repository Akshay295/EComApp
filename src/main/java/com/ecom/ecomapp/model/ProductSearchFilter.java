package com.ecom.ecomapp.model;

import lombok.Data;

@Data
public class ProductSearchFilter {

	private String productName;
	private String brandName;
	private String category;
	private String description;
	private Integer minPrice;
	private Integer maxPrice;
}
