package cg.products.productrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cg.products.productrest.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

	
	
}
