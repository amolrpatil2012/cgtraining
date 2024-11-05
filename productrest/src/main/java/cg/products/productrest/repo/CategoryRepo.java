package cg.products.productrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cg.products.productrest.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
