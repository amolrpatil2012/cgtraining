package cg.products.productrest.service;

import java.util.List;

import cg.products.productrest.dto.ProductResponseDto;
import cg.products.productrest.entities.Product;

public interface ProductService {
	
	String  save ( Product product);
	List<Product> findAll();
	Product findById(long id);
	String delete(long id);
	Product update(long id , Product newProduct);
	String assignProductToCat ( long pid , long catid);
	ProductResponseDto getProductInfo(long pid);

}
