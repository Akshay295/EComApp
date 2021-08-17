package com.ecom.ecomapp.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ecom.ecomapp.entity.Product;
import com.ecom.ecomapp.model.ProductSearchFilter;

@Repository
public class ProductRepositoryCustomImpl implements  ProductRepositoryCustom{

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public List<Product> findProductByFilter(ProductSearchFilter filter) {
		System.out.print(filter);
		System.out.print(em);
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Product> cq = cb.createQuery(Product.class);
	    
	    Root<Product> product = cq.from(Product.class);
	    List<Predicate> predicates = new ArrayList<>();
	    
	    if (filter.getProductName() != null) {
	        predicates.add(cb.like(product.get("name"), "%" + filter.getProductName() + "%"));
	    }
	    if (filter.getBrandName() != null) {
	        predicates.add(cb.like(product.get("brandName"), "%" + filter.getBrandName() + "%"));
	    }
	    if (filter.getCategory() != null) {
	        predicates.add(cb.like(product.get("category"), "%" + filter.getCategory() + "%"));
	    }
	    if (filter.getDescription() != null) {
	        predicates.add(cb.like(product.get("description"), "%" + filter.getDescription() + "%"));
	    }
	    if (filter.getMinPrice() !=0) {
	        predicates.add(cb.greaterThan(product.get("price"), filter.getMinPrice()));
	    }
	    if (filter.getMaxPrice() !=0) {
	        predicates.add(cb.lessThan(product.get("price"), filter.getMaxPrice()));
	    }
	    
	    
	    cq.where(predicates.toArray(new Predicate[0]));

	    return em.createQuery(cq).getResultList();
		
	}

}
