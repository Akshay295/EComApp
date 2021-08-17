package com.ecom.ecomapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ecomapp.entity.Cart;
import com.ecom.ecomapp.entity.OrderDetails;
import com.ecom.ecomapp.entity.ProductOrder;
import com.ecom.ecomapp.model.CartResponse;
import com.ecom.ecomapp.repository.OrderDetailsRepository;
import com.ecom.ecomapp.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	CartService cartService;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	public String placeOrder(Integer userid) {
		List<CartResponse> cart=cartService.getCart(userid);
		
		//create order
		ProductOrder order=new ProductOrder();
		order.setUserid(userid);
		order=orderRepository.save(order);
		
		Integer totalAmount=0;
		for(CartResponse item:cart) {
			totalAmount=totalAmount+(item.getQuantity()*item.getProduct().getPrice());
		}
		//Make Payment
		Integer paymentId=paymentService.makePayment(order.getOrderid(),userid,totalAmount);
		
		//Update payment
		order.setPaymentid(paymentId);
		orderRepository.save(order);
		
		//Add Entry to order details for each Product 
		for(CartResponse item:cart) {
			OrderDetails od=new OrderDetails();
			od.setOrderid(order.getOrderid());
			od.setProductid(item.getProduct().getProductId());
			od.setStatus("placed");
			orderDetailsRepository.save(od);
			item.getProduct().setQuantity(item.getProduct().getQuantity()-item.getQuantity());
			productService.addProduct(item.getProduct());
			Cart c=new Cart();
			c.setId(item.getId());
			cartService.delete(c);
		}
		return "Order Placed Successfully";
	}
}
