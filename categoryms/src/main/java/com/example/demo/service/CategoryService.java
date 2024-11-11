package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Category;




public interface CategoryService {
	CategoryDto  save ( CategoryDto category);
	List<CategoryDto> findAll();
	CategoryDto findById(long id);
	String delete(long id);
	CategoryDto update(long id , CategoryDto newCategory);
	Set<ProductDto> findProductsByCatId (long id);
}
