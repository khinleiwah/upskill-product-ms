package com.upskill.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upskill.product.model.Product;
import com.upskill.product.model.ProductWrapper;
import com.upskill.product.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	public ProductRepository repo;
	
	public void save(Product theProduct) {
		// TODO Auto-generated method stub
		repo.save(theProduct);
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(new Product());
	}

}
