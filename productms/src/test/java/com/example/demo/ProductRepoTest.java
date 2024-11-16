package com.example.demo.repo;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.entities.Product;
import com.example.demo.exceptions.ProductNotFoundException;


public class ProductRepoTest {
	
	@Mock
	ProductRepo productRepo;
	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes the mocks
    }
	
	public Product getProductObject()
	{
		Product product = new Product();
		product.setPid(1);
		product.setName("Laptop");
		product.setPrice(10000);
		return product;
	}
	public List<Product> getListOfProducts()
	{
		Product product1 = new Product();
		product1.setPid(1);
		product1.setName("Laptop");
		product1.setPrice(10000);
		
		Product product2 = new Product();
		product2.setPid(2);
		product2.setName("Mobile");
		product2.setPrice(20000);
		
		return List.of(product1,product2);
	}
	
	@DisplayName("JUnit test for findAll products operation")
	@Test
    void findAll_should_return_product_list() {
		List<Product> products = getListOfProducts();		
        // When
        when(productRepo.findAll()).thenReturn(products);
        // Act
        List<Product> temp = productRepo.findAll();
        // Assert
        Assertions.assertEquals(2, temp.size());
    }
	@DisplayName("JUnit test for findById operation")
	@Test
    void findById_should_return_product() {
		Product product = getProductObject();		
        // When
        when(productRepo.findById(1l)).thenReturn(Optional.of(product));
        // Act
        Optional<Product> temp = productRepo.findById(1l);
        // Assert
        assertThat(temp).isPresent();
        assertThat(temp.get().getName().equals("Laptop"));
    }
	@DisplayName("JUnit test for save product operation")
	@Test
	void save_should_insert_new_product()
	{
			Product product = getProductObject();
			//when
			when(productRepo.save(product)).thenReturn(product);
			// Act
			Product savedProduct = productRepo.save(product);
			//assert
			assertThat ( savedProduct).isNotNull();
			assertThat(savedProduct.getName().equals("Laptop"));
	}
	@DisplayName("JUnit test for update product operation")
	@Test
	void save_with_id_should_update_existing_product()
	{
			//Arrange			
			Product existingProduct = new Product();
			existingProduct.setName("Laptop");
			existingProduct.setPid(1l);
			existingProduct.setPrice(10000);
			Product updatedProduct = new Product();
			updatedProduct.setPid(1l);
			updatedProduct.setName("Gaming Laptop");
			updatedProduct.setPrice(20000);
			//when
			when(productRepo.findById(1l)).thenReturn(Optional.of(existingProduct));
			when(productRepo.save(updatedProduct)).thenReturn(updatedProduct);
			// Act
			Optional<Product> productOptional = productRepo.findById(1l);
			Product productToUpdate=null;
	        if (productOptional.isPresent()) {
	            productToUpdate = productOptional.get();
	            productToUpdate.setName(updatedProduct.getName());
	            productToUpdate.setPrice(updatedProduct.getPrice());
	            productRepo.save(productToUpdate);
	        }
	        
			//assert
	        verify(productRepo, times(1)).findById(1l);
	        verify(productRepo, times(1)).save(productToUpdate);
			assertThat (productToUpdate).isNotNull();
			assertThat(productToUpdate.getName().equals("Gaming Laptop"));
	}
	@DisplayName("JUnit test for delete operation")
	@Test
    void delete_should_delete_product() {
		Product product = getProductObject();		
        // When
        when(productRepo.findById(1l)).thenReturn(Optional.of(product));
        // Act
        Optional<Product> temp = productRepo.findById(1l);
        if(temp.isPresent())
        	productRepo.delete(temp.get());
        // Assert
        verify(productRepo,times(1)).delete(product);
        
        
        
    }

	
}
