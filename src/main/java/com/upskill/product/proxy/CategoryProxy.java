package com.upskill.product.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CATEGORY")
public interface CategoryProxy {
	
	@GetMapping("/category/{id}")
	public String getCategoryById(@PathVariable int id);
}
