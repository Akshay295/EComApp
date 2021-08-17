package com.ecom.ecomapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.ecomapp.entity.Product;

@Repository
public interface  ProductRepository extends CrudRepository<Product, Integer>,ProductRepositoryCustom{

	 @Query(nativeQuery=true, value="SELECT * FROM PRODUCT WHERE NAME LIKE %:productName% AND BRAND_NAME LIKE %:brandName% AND DESCRIPTION LIKE %:description% AND CATEGORY LIKE %:category% AND PRICE BETWEEN :minPrice AND :maxPrice ")
	 public List<Product> findProdcutsBySearchFilter(String productName,String brandName,String description,String category,Integer minPrice,Integer maxPrice);
	 
	
}
