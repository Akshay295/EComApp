package com.ecom.ecomapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.ecomapp.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{

	 @Query(nativeQuery=true, value="SELECT * FROM CART WHERE USERID=:userid ")
	 public List<Cart> getCart(Integer userid);
}
