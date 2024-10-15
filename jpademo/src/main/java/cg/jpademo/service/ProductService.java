package cg.jpademo.service;

import cg.jpademo.entities.Product;
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
	
	public void addProduct ( Product product)
	{
		manager.getTransaction().begin();
		// temp change not reflecting in database table
		manager.persist(product);				
		// will execute insert query and store in database table
		manager.getTransaction().commit();
		
	}
	public Product findById ( int pid)
	{
		return manager.find(Product.class, pid);
	}
	
	// call from main ps.delete(4)
	public void delete ( int pid)
	{
		Product p = findById(pid);
		manager.getTransaction().begin();
		manager.remove(p);
		manager.getTransaction().commit();
	}
	
	public void updateProduct ( Product newProduct , int pid)
	{
		Product p = findById(pid);
		manager.getTransaction().begin();
		p.setPname(newProduct.getPname());
		p.setPrice(newProduct.getPrice());
		manager.persist(p);
		manager.getTransaction().commit();
	}
	
	
	
	
	
}
