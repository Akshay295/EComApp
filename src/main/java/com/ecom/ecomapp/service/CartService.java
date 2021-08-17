package com.ecom.ecomapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ecomapp.entity.Cart;
import com.ecom.ecomapp.model.CartResponse;
import com.ecom.ecomapp.repository.CartRepository;
import com.ecom.ecomapp.repository.ProductRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public Cart addItem(Cart cart) {
		return cartRepository.save(cart);
	}
	
	public List<CartResponse> getCart(Integer userid){
		List<CartResponse> cartResponse=new ArrayList<>();
		List<Cart> cartList=cartRepository.getCart(userid);
		for(Cart c:cartList) {
			CartResponse cartRes=new CartResponse();
			cartRes.setId(c.getId());
			cartRes.setProduct(productRepository.findById(c.getProductid()).get());
			cartRes.setQuantity(c.getQuantity());
			cartRes.setUserid(c.getUserid());
			cartResponse.add(cartRes);
		}
		return cartResponse;
	}
	
	public void delete(Cart cart) {
		cartRepository.delete(cart);
	}
}
