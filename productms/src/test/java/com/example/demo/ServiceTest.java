package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Product;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repo.ProductRepo;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private ProductRepo productRepository;

    @InjectMocks
    private ProductServiceImpl productService;
    
    
    
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

	 // JUnit test for save method
    @DisplayName("JUnit test for save method")
    @Test
    public void givenProductObject_whenSaveProduct_thenReturnProductObject(){
       
    	// Arrange
    	Product product = new Product();
    	product.setName("Laptop");
    	product.setPrice(10000);
    	Product savedProduct = new Product();
    	savedProduct.setName("Laptop");
    	savedProduct.setPrice(10000);
    	savedProduct.setPid(1);
    	
    	//when
    	
    	when(productRepository.save(any(Product.class))).thenReturn(savedProduct);
    	
    	// Act
    	ProductDto dto = ProductMapper.productToProductDto(product);
        ProductDto resultDto = productService.save(dto);
        Product result = ProductMapper.productDtoToProduc(resultDto);
        // Assert
        assertThat(resultDto).isNotNull();
        assertThat(resultDto.getPid()).isEqualTo(1l);
        assertThat(resultDto.getName()).isEqualTo("Laptop");
        verify(productRepository,times(1)).save(any(Product.class));
    }

    // Junit test for findAll method
    @DisplayName("JUnit test for findAll method")
    @Test
    void testFindAllProducts() {
        // Arrange
        List<Product> products = getListOfProducts();

        //when
        when(productRepository.findAll()).thenReturn(products);

        // Act
        List<ProductDto> result = productService.findAll();

        // Assert
        assertThat(result).isNotNull();
        assertThat(2).isEqualTo(result.size());
        assertThat("Laptop").isEqualTo(result.get(0).getName());
        verify(productRepository, times(1)).findAll();
    }

    // Junit test for findById method
    @DisplayName("JUnit test for findById method")
    @Test
    void testFindById() {
        // Arrange
        Product product = getProductObject();

        //when
        when(productRepository.findById(1l)).thenReturn(Optional.of(product));

        // Act
        ProductDto result = productService.findById(1l);

        // Assert
        assertThat(result).isNotNull();       
        assertThat("Laptop").isEqualTo(result.getName());
        verify(productRepository, times(1)).findById(1l);
    }
 // Junit test for delete method
    @DisplayName("JUnit test for delete method")
    @Test
    void testDelete() {
    	// Arrange
        Long productId = 1L;
        Product product = getProductObject();

        // Act
        when(productRepository.findById(1l)).thenReturn(Optional.of(product));
        String result = productService.delete(productId);

        // Assert
        assertThat(result).isEqualTo("Product deleted Successfully!!");
        //verify(productRepository, times(1)).delete(product);
    }
    @Test
    void testUpdateProduct() {
        // Arrange
        Long productId = 1L;
        Product existingProduct = new Product();
		existingProduct.setName("Laptop");
		existingProduct.setPid(1l);
		existingProduct.setPrice(10000);
		Product updatedProduct = new Product();
		updatedProduct.setPid(1l);
		updatedProduct.setName("Gaming Laptop");
		updatedProduct.setPrice(20000);
		
		ProductDto updateDto = ProductMapper.productToProductDto(updatedProduct);
		//when
        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(existingProduct)).thenReturn(updatedProduct);

        // Act
        ProductDto result = productService.update(productId, updateDto);
        
        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Gaming Laptop");
        //verify(productRepository, times(1)).findById(productId);
        //verify(productRepository, times(1)).save(existingProduct);
    }

    @Test
    @DisplayName("Junit Test to Check for Exception")
    void testFindByIdThrowsExceptionWhenProductNotFound() {
        // Arrange
        long productId = 1L;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // Act & Assert
        
        Exception exception = assertThrows(ProductNotFoundException.class, () -> productService.findById(productId));

        // Verify the exception message
        assertEquals("Product not found",exception.getMessage());

        // Verify repository interaction
        verify(productRepository, times(1)).findById(productId);
    }
}
