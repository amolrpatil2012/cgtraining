package cg.jpademo.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductService {

	EntityManager manager;  // manages all entities
	
	public ProductService()
	{
		EntityManagerFactory factory=
		Persistence.createEntityManagerFactory("product_details");

		manager = factory.createEntityManager();

	}
	
	
}
