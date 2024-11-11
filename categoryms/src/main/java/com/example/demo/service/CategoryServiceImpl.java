package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Category;
import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repo.CategoryRepo;


@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepo repo;
	
	@Override
	public CategoryDto save(CategoryDto catDto) {
		Category cat = CategoryMapper.categoryDtoToCategory(catDto);
		Category newCat = repo.save(cat);
		return CategoryMapper.categoryToCategoryDto(newCat);
		
	}

	@Override
	public List<CategoryDto> findAll() {
		// TODO Auto-generated method stub
		List<Category> catList = repo.findAll();
		List<CategoryDto> catDtoList = new ArrayList<CategoryDto>();
		catList.forEach(cat->catDtoList.add(CategoryMapper.categoryToCategoryDto(cat)));
		return catDtoList;
	}

	@Override
	public CategoryDto findById(long id) {
		// TODO Auto-generated method stub
		//System.out.println(repo.findById(id).orElse(null));
		Category category= repo.findById(id).orElseThrow(()->new CategoryNotFoundException("Category Not Found"));
		return CategoryMapper.categoryToCategoryDto(category);
	}

	@Override
	public String delete(long id) {
		CategoryDto dto = findById(id);
		Category cat = CategoryMapper.categoryDtoToCategory(dto);
		repo.delete(cat);
		return "Category deleted Successfully!!";
	}

	@Override
	public CategoryDto update(long id, CategoryDto newCategory) {

		CategoryDto dto = findById(id);
		Category category = CategoryMapper.categoryDtoToCategory(dto);
		category.setCatname(newCategory.getCatname());
		category.setDesc(newCategory.getDesc());
		repo.save(category);
		return dto;
	}

	@Override
	public Set<ProductDto> findProductsByCatId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
