package com.ecom.ecomapp.repository;

import java.util.List;

import com.ecom.ecomapp.entity.Product;
import com.ecom.ecomapp.model.ProductSearchFilter;

public interface ProductRepositoryCustom {
	List<Product> findProductByFilter(ProductSearchFilter filter);
}
