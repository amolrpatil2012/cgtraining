package com.example.demo.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entities.Category;
import com.example.demo.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")		// localhost:8080/categories
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	//http://localhost:8080/categories
	@PostMapping
	public ResponseEntity<CategoryDto> save (@Valid @RequestBody CategoryDto cat)
	{
		return new ResponseEntity<CategoryDto>(service.save(cat),HttpStatus.CREATED);
	}
	//http://localhost:8080/categories
	@GetMapping
	public ResponseEntity<List<CategoryDto>>findAll ()
	{
		return new ResponseEntity<List<CategoryDto>>(service.findAll(),HttpStatus.OK);
	}
	//http://localhost:8080/categories/1
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto>findById (@PathVariable long id)
	{
			return new ResponseEntity<CategoryDto>(service.findById(id),HttpStatus.OK);
	}
	
	//http://localhost:8080/categories/1
	@DeleteMapping("/{id}")
	public ResponseEntity<String>delete (@PathVariable long id)
	{
		return new ResponseEntity<String>(service.delete(id),HttpStatus.OK);
	}
	
	//http://localhost:8080/categories/1
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto>update (@Valid @RequestBody CategoryDto cat,@PathVariable long id)
	{
			return new ResponseEntity<CategoryDto>(service.update(id,cat),HttpStatus.OK);
	}	
}



