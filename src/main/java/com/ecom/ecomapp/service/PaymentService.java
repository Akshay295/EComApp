package com.ecom.ecomapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ecomapp.entity.Payment;
import com.ecom.ecomapp.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	public Integer makePayment(Integer orderid,Integer userid,Integer amount) {
		
		//Call payment APIS & make Payment 
		
		Payment payment=new Payment();
		payment.setUserid(userid);
		payment.setOrderid(orderid);
		payment.setAmount(amount);
		payment.setStatus("success");
		
		payment=paymentRepository.save(payment);
		
		return payment.getId();
	}
}
