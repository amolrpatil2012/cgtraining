package cg.products.productrest.controllers;

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

import cg.products.productrest.entities.Category;
import cg.products.productrest.entities.Product;
import cg.products.productrest.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")		// localhost:8080/categories
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	//http://localhost:8080/categories
	@PostMapping
	public ResponseEntity<String> save (@Valid @RequestBody Category cat)
	{
		return new ResponseEntity<String>(service.save(cat),HttpStatus.CREATED);
	}
	//http://localhost:8080/categories
	@GetMapping
	public ResponseEntity<List<Category>>findAll ()
	{
		return new ResponseEntity<List<Category>>(service.findAll(),HttpStatus.OK);
	}
	//http://localhost:8080/categories/1
	@GetMapping("/{id}")
	public ResponseEntity<Category>findById (@PathVariable long id)
	{
			return new ResponseEntity<Category>(service.findById(id),HttpStatus.OK);
	}
	//http://localhost:8080/categories/1/products
		@GetMapping("/{id}/products")
		public ResponseEntity<Set<Product>>findProductsByCatId (@PathVariable long id)
		{
				return new ResponseEntity<Set<Product>>(service.findProductsByCatId (id),HttpStatus.OK);
		}
	//http://localhost:8080/categories/1
	@DeleteMapping("/{id}")
	public ResponseEntity<String>delete (@PathVariable long id)
	{
		return new ResponseEntity<String>(service.delete(id),HttpStatus.OK);
	}
	
	//http://localhost:8080/categories/1
	@PutMapping("/{id}")
	public ResponseEntity<Category>update (@Valid @RequestBody Category cat,@PathVariable long id)
	{
			return new ResponseEntity<Category>(service.update(id,cat),HttpStatus.OK);
	}	
}



