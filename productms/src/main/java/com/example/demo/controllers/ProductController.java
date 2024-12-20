package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductResponseDto;
import com.example.demo.entities.Product;
import com.example.demo.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")		// localhost:8080/products
@Tag(description = "Product Service" , name="ProductCRUD")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	//http://localhost:8080/products
	@PostMapping
	@Operation(
			summary = "Saving Product",
			description = "Saving Product"
			
			)
	@ApiResponse(
			
			responseCode = "201",
			description = "Will Retutn HttpStatus.CREATED"
			
			)
	public ResponseEntity<ProductDto> save (@Valid @RequestBody ProductDto product)
	{
		return new ResponseEntity<ProductDto>(service.save(product),HttpStatus.CREATED);
	}
	//http://localhost:8080/products
	@GetMapping
	public ResponseEntity<List<ProductDto>>findAll ()
	{
		return new ResponseEntity<List<ProductDto>>(service.findAll(),HttpStatus.OK);
	}
	//http://localhost:8080/products/1
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto>findById (@PathVariable long id)
	{
			return new ResponseEntity<ProductDto>(service.findById(id),HttpStatus.OK);
	}
	//http://localhost:8080/products/1
	@DeleteMapping("/{id}")
	public ResponseEntity<String>delete (@PathVariable long id)
	{
		return new ResponseEntity<String>(service.delete(id),HttpStatus.OK);
	}
	
	//http://localhost:8080/products/1
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto>update (@Valid @RequestBody ProductDto product,@PathVariable long id)
	{
			return new ResponseEntity<ProductDto>(service.update(id,product),HttpStatus.OK);
	}	
	
//	//http://localhost:8080/products/pid/1/catid/1
//	@GetMapping("/pid/{pid}/catid/{catid}")
//	public ResponseEntity<String> assignProductToCat ( @PathVariable long pid , @PathVariable long catid)
//	{
//		return new ResponseEntity<String>(service.assignProductToCat(pid,catid),HttpStatus.OK);
//	}
	
	//http://localhost:8080/products/info/1
	@GetMapping("/info/{id}")
	public ResponseEntity<ProductResponseDto>findProductInfo (@PathVariable long id)
	{
				return new ResponseEntity<ProductResponseDto>(service.getProductInfo(id),HttpStatus.OK);
	}	
	
	
	
}



