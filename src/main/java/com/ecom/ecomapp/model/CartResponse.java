package com.ecom.ecomapp.model;

import com.ecom.ecomapp.entity.Product;

import lombok.Data;

@Data
public class CartResponse {
	private Integer id;
	private Integer userid;
	private Product product;
	private Integer quantity;
	
}
