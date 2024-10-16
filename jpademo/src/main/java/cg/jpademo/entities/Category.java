package cg.jpademo.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String catname;
	String description;
	
	@OneToMany(mappedBy="category", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	Set<Product> products;
	
	public void addProduct ( Product p)
	{
		if ( products == null)
			products = new HashSet<Product>();
		products.add(p);
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Long getId() {
		return id;
	}
	public Category() {
		super();
	}
	public Category( String catname, String description) {
		super();
		
		this.catname = catname;
		this.description = description;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
