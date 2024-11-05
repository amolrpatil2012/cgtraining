package cg.products.productrest.controllers;

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

import cg.products.productrest.dto.ProductResponseDto;
import cg.products.productrest.entities.Product;
import cg.products.productrest.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")		// localhost:8080/products
public class ProductController {
	
	@Autowired
	ProductService service;
	
	//http://localhost:8080/products
	@PostMapping
	public ResponseEntity<String> save (@Valid @RequestBody Product product)
	{
		return new ResponseEntity<String>(service.save(product),HttpStatus.CREATED);
	}
	//http://localhost:8080/products
	@GetMapping
	public ResponseEntity<List<Product>>findAll ()
	{
		return new ResponseEntity<List<Product>>(service.findAll(),HttpStatus.OK);
	}
	//http://localhost:8080/products/1
	@GetMapping("/{id}")
	public ResponseEntity<Product>findById (@PathVariable long id)
	{
			return new ResponseEntity<Product>(service.findById(id),HttpStatus.OK);
	}
	//http://localhost:8080/products/1
	@DeleteMapping("/{id}")
	public ResponseEntity<String>delete (@PathVariable long id)
	{
		return new ResponseEntity<String>(service.delete(id),HttpStatus.OK);
	}
	
	//http://localhost:8080/products/1
	@PutMapping("/{id}")
	public ResponseEntity<Product>update (@Valid @RequestBody Product product,@PathVariable long id)
	{
			return new ResponseEntity<Product>(service.update(id,product),HttpStatus.OK);
	}	
	
	//http://localhost:8080/products/pid/1/catid/1
	@GetMapping("/pid/{pid}/catid/{catid}")
	public ResponseEntity<String> assignProductToCat ( @PathVariable long pid , @PathVariable long catid)
	{
		return new ResponseEntity<String>(service.assignProductToCat(pid,catid),HttpStatus.OK);
	}
	
	//http://localhost:8080/products/info/1
	@GetMapping("/info/{id}")
	public ResponseEntity<ProductResponseDto>findProductInfo (@PathVariable long id)
	{
				return new ResponseEntity<ProductResponseDto>(service.getProductInfo(id),HttpStatus.OK);
	}	
	
	
	
}



