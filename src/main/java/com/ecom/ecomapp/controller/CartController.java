package com.ecom.ecomapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ecomapp.entity.Cart;
import com.ecom.ecomapp.model.CartResponse;
import com.ecom.ecomapp.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping("cart")
	public ResponseEntity<Cart> addItem(@RequestBody Cart cart){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addItem(cart));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("cart")
	public ResponseEntity<List<CartResponse>> getItems(@RequestParam Integer userid){
		
		return ResponseEntity.status(HttpStatus.OK).body(cartService.getCart(userid));
	}
}
