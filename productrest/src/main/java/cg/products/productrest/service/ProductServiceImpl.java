package cg.products.productrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.products.productrest.dto.ProductResponseDto;
import cg.products.productrest.entities.Category;
import cg.products.productrest.entities.Product;
import cg.products.productrest.exceptions.ProductNotFoundException;
import cg.products.productrest.mapper.ProductMapper;
import cg.products.productrest.repo.ProductRepo;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	@Autowired
	CategoryService catService;
	
	@Override
	public String save(Product product) {
		repo.save(product);
		return "Product saved Successfully !!";
		
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product findById(long id) {
		// TODO Auto-generated method stub
		
		return repo.findById(id).orElseThrow(()->new ProductNotFoundException("Product Not Found"));
	}

	@Override
	public String delete(long id) {
		Product product = findById(id);
		repo.delete(product);
		return "Product deleted Successfully!!";
	}

	@Override
	public Product update(long id, Product newProduct) {
		Product product = findById(id);
		product.setName(newProduct.getName());
		product.setCategory(newProduct.getCategory());
		product.setPrice(newProduct.getPrice());
		repo.save(product);
		return product;
	}

	@Override
	public String assignProductToCat(long pid, long catid) {
		
			Product product = findById(pid);
			Category category = catService.findById(catid);
			product.setCategory(category);
			//category.addProduct(product);
			save(product);
			return product.getName() + " Assigned to Category " + category.getCatname();
			
		
		
	}

	@Override
	public ProductResponseDto getProductInfo(long pid) {
		
		Product product = findById(pid);
		return ProductMapper.productToProudctResponseDto(product);
	}

}
