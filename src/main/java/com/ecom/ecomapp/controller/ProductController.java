package com.ecom.ecomapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ecomapp.entity.Product;
import com.ecom.ecomapp.model.ProductSearchFilter;
import com.ecom.ecomapp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {

		System.out.println(product.toString());
		System.out.println(product.getName());
		try {
			product = productService.addProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(product);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("product")
	public ResponseEntity<List<Product>> getProducts(){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.getProducts());
	}
	
	@PostMapping("product/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestBody ProductSearchFilter filter){
		return ResponseEntity.status(HttpStatus.OK).body(productService.searchProduct(filter));
	}
}
