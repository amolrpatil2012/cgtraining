package com.example.demo.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controllers.ProductController;
import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	 @Autowired
	 private MockMvc mockMvc;

	 @MockBean
	 private ProductService productService;

	 private static final String BASE_URL = "http://localhost:8080/products";
	
	 @Test
	 void testSaveProduct() throws Exception {
	        // Arrange
		 	Product product = new Product();			
			product.setName("Laptop");
			product.setPrice(10000);
			
			Product savedProduct = new Product();
			savedProduct.setPid(1);
			savedProduct.setName("Laptop");
			savedProduct.setPrice(10000);
			
	        ProductDto productDto = ProductMapper.productToProductDto(product);
	        ProductDto savedProductDto = ProductMapper.productToProductDto(savedProduct);

	        when(productService.save(any(ProductDto.class))).thenReturn(savedProductDto);

	        // Act & Assert
	        
	        mockMvc.perform(post(BASE_URL)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content("{\"name\":\"Laptop\",\"price\":\"10000\"}"))
	                .andExpect(status().isCreated())
	                .andExpect(jsonPath("$.pid").value(1L))
	                .andExpect(jsonPath("$.name").value("Laptop"))
	                .andExpect(jsonPath("$.price").value("10000"));
	                
	    }
	 
	 	@Test
	    void testFindById() throws Exception {
	        // Arrange
	 		Product product = new Product();
			product.setPid(1);
			product.setName("Laptop");
			product.setPrice(10000);
			
	        ProductDto productDto = ProductMapper.productToProductDto(product);
	        
	        when(productService.findById(1l)).thenReturn(productDto);

	        // Act & Assert
	        mockMvc.perform(get(BASE_URL + "/{id}", 1l))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.pid").value(1l))
	                .andExpect(jsonPath("$.name").value("Laptop"))
	                .andExpect(jsonPath("$.price").value("10000"));
	    }
	 	
	 	 @Test
	     void testFindAll() throws Exception {
	         // Arrange
	 		Product product1 = new Product();
			product1.setPid(1);
			product1.setName("Laptop");
			product1.setPrice(10000);
			
			Product product2 = new Product();
			product2.setPid(2);
			product2.setName("Mobile");
			product2.setPrice(20000);
			
			List<Product> products= List.of(product1,product2);
			List<ProductDto> productDtos = new ArrayList<ProductDto>();
			products.stream().forEach(p->productDtos.add(ProductMapper.productToProductDto(p)));
	         
	        when(productService.findAll()).thenReturn(productDtos);

	         // Act & Assert
	         mockMvc.perform(get(BASE_URL))
	                 .andExpect(status().isOk())
	                 .andExpect(jsonPath("$.size()").value(2))
	                 .andExpect(jsonPath("$[0].pid").value(1L))
	                 .andExpect(jsonPath("$[0].name").value("Laptop"))
	                 .andExpect(jsonPath("$[1].pid").value(2L))
	                 .andExpect(jsonPath("$[1].name").value("Mobile"));
	     }
	 	 
	 	 @Test
	     void testDeleteProduct() throws Exception {
	         // Arrange
	         long productId = 1L;
	         when(productService.delete(productId)).thenReturn("Product deleted Successfully!!");

	         // Act & Assert
	         mockMvc.perform(delete(BASE_URL + "/{id}", productId))
	                 .andExpect(status().isOk())
	                 .andExpect(content().string("Product deleted Successfully!!"));
	     }
	 	 
	 	@Test
	    void testUpdateProduct() throws Exception {
	        // Arrange
	        long productId = 1L;
	     // Arrange
		 	Product product = new Product();			
			product.setName("Laptop");
			product.setPrice(10000);
			
			Product savedProduct = new Product();
			savedProduct.setPid(1);
			savedProduct.setName("Gaming Laptop");
			savedProduct.setPrice(20000);
			
	        ProductDto productDto = ProductMapper.productToProductDto(product);
	        ProductDto updatedProduct = ProductMapper.productToProductDto(savedProduct);

	        
	        when(productService.update(eq(productId), any(ProductDto.class))).thenReturn(updatedProduct);

	        // Act & Assert
	        mockMvc.perform(put(BASE_URL + "/{id}", productId)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content("{\"name\":\"Gaming Laptop\",\"price\":\"20000\"}"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.pid").value(productId))
	                .andExpect(jsonPath("$.name").value("Gaming Laptop"))
	                .andExpect(jsonPath("$.price").value("20000"));
	    }
}
