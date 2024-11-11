package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.CategoryDto;

@FeignClient(url="http://localhost:8080",name = "deptclient")

public interface APIClient {

	@GetMapping("categories/{cid}")
	CategoryDto getCategory(@PathVariable long cid);

}
