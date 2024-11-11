package com.example.demo.mapper;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entities.Category;

public class CategoryMapper {
	
	public static CategoryDto categoryToCategoryDto ( Category category)
	{
		CategoryDto dto = new CategoryDto();
		dto.setCatname(category.getCatname());
		dto.setCid(category.getCid());
		dto.setDesc(category.getDesc());
		return dto;
	}
	public static Category categoryDtoToCategory ( CategoryDto category)
	{
		Category cat = new Category();
		cat.setCatname(category.getCatname());
		cat.setCid(category.getCid());
		cat.setDesc(category.getDesc());
		return cat;
	}

}
