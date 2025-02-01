package com.upskill.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upskill.product.service.ProductService;
import com.upskill.product.model.Product;
import com.upskill.product.model.ProductWrapper;
import com.upskill.product.proxy.CategoryProxy;
import com.upskill.product.repository.ProductRepository;

@RestController
public class ProductController {
	@Autowired
	private CategoryProxy proxy;
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> retrieveAllProducts() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/product/details/{id}")
	public ResponseEntity<ProductWrapper> retrieveProductDetailById(@PathVariable int id) {

		List<Product> products = repo.findAllById(id);

		for (Product p : products) {
			
			String cat = proxy.getCategoryById(p.getCategoryId());

			ProductWrapper wrapper = new ProductWrapper();
			wrapper.setId(p.getId());
			wrapper.setName(p.getName());
			wrapper.setPrice(p.getPrice());
			wrapper.setBrand(p.getBrand());
			wrapper.setStock(p.getStock());
			wrapper.setCategory(cat);
			wrapper.setImage(p.getImage());
			return new ResponseEntity<>(wrapper, HttpStatus.OK);
			
		}

		return null;
	}
	
	@GetMapping("/product")
	public ResponseEntity<List<ProductWrapper>> retrieveProductsByCategoryId(@RequestParam(name="category", defaultValue = "0")  Integer id, @RequestParam(name="searchValue", defaultValue="") String search) {
		
		List<ProductWrapper> productList = new ArrayList<>();
		
		if(Integer.valueOf(id) == 0) {
			List<Product> products = repo.findByNameContains(search);

			for (Product p: products) {
				String cat = proxy.getCategoryById(p.getCategoryId());
				
	        	ProductWrapper wrapper = new ProductWrapper();
	            wrapper.setId(p.getId());
	            wrapper.setName(p.getName());
	            wrapper.setPrice(p.getPrice());
	            wrapper.setBrand(p.getBrand());
	            wrapper.setStock(p.getStock());
	            wrapper.setCategory(cat);
	            wrapper.setImage(p.getImage());
	           
	            productList.add(wrapper);
	        }
			
		} else {
			String category = proxy.getCategoryById(id);		
			List<Product> products = repo.findByCategoryIdAndNameContains(id, search);
			
	        for (Product p: products) {
	        	ProductWrapper wrapper = new ProductWrapper();
	            wrapper.setId(p.getId());
	            wrapper.setName(p.getName());
	            wrapper.setPrice(p.getPrice());
	            wrapper.setBrand(p.getBrand());
	            wrapper.setStock(p.getStock());
	            wrapper.setCategory(category);
	            wrapper.setImage(p.getImage());
	           
	            productList.add(wrapper);
	        }
		}
        
        return new ResponseEntity<>(productList, HttpStatus.OK);
	}
	
	@PostMapping("/product/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product theProduct) {
		service.save(theProduct);
		
		return new ResponseEntity<>(service.getProductById(theProduct.getId()), HttpStatus.CREATED);
		
	}
}
