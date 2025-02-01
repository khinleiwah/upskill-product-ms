package com.upskill.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upskill.product.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{


	List<Product> findByCategoryIdAndNameContains(int id, String search);


	@NativeQuery(value = "SELECT * FROM product p WHERE p.name like %?1%")
//	@Query("select * from product p where p.name like ?1%")//, nativeQuery=true
	List<Product> findByNameContains(String search);


	List<Product> findAllById(int id);
	
	
}