package com.ecom.ecomapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ecomapp.entity.Product;
import com.ecom.ecomapp.model.ProductSearchFilter;
import com.ecom.ecomapp.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		
		productRepository.save(product);
		return product;
	}
	
	public List<Product> getProducts(){
		
		Iterable<Product> products=productRepository.findAll();
		List<Product> result = new ArrayList<>();
	    for (Product p : products) {
	        result.add(p);
	    }
		return result;
	}
	
	public List<Product> searchProduct(ProductSearchFilter filter){
		return productRepository.findProdcutsBySearchFilter(filter.getProductName(),filter.getBrandName(),filter.getDescription(),filter.getCategory(),filter.getMinPrice(),filter.getMaxPrice());
	}
	
	
}
