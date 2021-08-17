package com.ecom.ecomapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.ecomapp.entity.ProductOrder;

@Repository
public interface OrderRepository extends CrudRepository<ProductOrder, Integer>{

}
