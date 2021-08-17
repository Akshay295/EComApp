package com.ecom.ecomapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ecomapp.model.OrderRequest;
import com.ecom.ecomapp.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping("order")
	public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest){
		
		return ResponseEntity.status(HttpStatus.OK).body(orderService.placeOrder(orderRequest.getUserid()));
	}
}
