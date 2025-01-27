package com.upskill.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upskill.product.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{


	List<Product> findByCategoryIdAndNameContains(int id, String search);


	List<Product> findByNameContains(String search);


	List<Product> findAllById(int id);
	
	
}