package com.ecom.ecomapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.ecomapp.entity.OrderDetails;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer>{

}
