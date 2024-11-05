package cg.products.productrest.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.products.productrest.entities.Category;
import cg.products.productrest.entities.Product;
import cg.products.productrest.exceptions.CategoryNotFoundException;
import cg.products.productrest.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepo repo;
	
	@Override
	public String save(Category cat) {
		repo.save(cat);
		return "Category saved Successfully !!";
		
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Category findById(long id) {
		// TODO Auto-generated method stub
		//System.out.println(repo.findById(id).orElse(null));
		return repo.findById(id).orElseThrow(()->new CategoryNotFoundException("Category Not Found"));
	}

	@Override
	public String delete(long id) {
		Category cat = findById(id);
		repo.delete(cat);
		return "Category deleted Successfully!!";
	}

	@Override
	public Category update(long id, Category newCategory) {
		Category category = findById(id);
		category.setCatname(newCategory.getCatname());
		category.setDesc(newCategory.getDesc());
		repo.save(category);
		return category;
	}

	@Override
	public Set<Product> findProductsByCatId(long id) {
		// TODO Auto-generated method stub
		return findById(id).getProducts();
	}

}
