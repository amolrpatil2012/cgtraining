package cg.jpademo.service;

import cg.jpademo.entities.Category;
import cg.jpademo.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CategoryService {
	

	EntityManager manager;  // manages all entities
	
	public CategoryService()
	{
		EntityManagerFactory factory=
		Persistence.createEntityManagerFactory("product_details");

		manager = factory.createEntityManager();

	}
	
	public void addCategory (Category category)
	{
		manager.getTransaction().begin();
		// temp change not reflecting in database table
		manager.persist(category);				
		// will execute insert query and store in database table
		manager.getTransaction().commit();
		
	}
	public Category findById ( int pid)
	{
		return manager.find(Category.class, pid);
	}

}
