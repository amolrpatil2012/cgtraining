package com.example.demo.service;


import java.util.List;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductResponseDto;
import com.example.demo.entities.Product;



public interface ProductService {
	
	ProductDto  save ( ProductDto product);
	List<ProductDto> findAll();
	ProductDto findById(long id);
	String delete(long id);
	ProductDto update(long id , ProductDto newProduct);
	ProductResponseDto getProductInfo(long id);


}
