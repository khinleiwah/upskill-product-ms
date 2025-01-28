package com.upskill.product.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CATEGORY-SERVICE", url = "http://44.198.179.107:8100")
public interface CategoryProxy {
	
	@GetMapping("/category/{id}")
	public String getCategoryById(@PathVariable int id);
}
