package cg.products.productrest.service;

import java.util.List;
import java.util.Set;

import cg.products.productrest.entities.Category;
import cg.products.productrest.entities.Product;


public interface CategoryService {
	String  save ( Category category);
	List<Category> findAll();
	Category findById(long id);
	String delete(long id);
	Category update(long id , Category newCategory);
	Set<Product> findProductsByCatId (long id);
}
