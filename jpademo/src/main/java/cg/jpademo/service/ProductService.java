package cg.jpademo.service;

import java.util.List;

import cg.jpademo.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

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
		
	public void deleteProduct ( int pid)
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
	
	// Select * From products ---> SQL
	// Select a From Product a ---> JPQL
	
	public List<Product> findAllProducts()
	{
		String query = " From Product";
		TypedQuery<Product> p = manager.createQuery(query,Product.class);
	
		return p.getResultList();
	}
	
	public List<Product> findProductsGreaterThanGivenPrice ( int price)
	{
		String query = "from Product a Where a.price > :pp";
		TypedQuery<Product> p = manager.createQuery(query,Product.class);
		p.setParameter("pp" , price);
		return p.getResultList();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
