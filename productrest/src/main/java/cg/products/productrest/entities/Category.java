package cg.products.productrest.entities;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


//@Data
@Entity
@Table(name="categories")
public class Category {
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cid;
	
	
	@Column(unique = true,nullable=false)
	@NotEmpty(message="Category Name can not be empty")
	private String catname;
	
	
	
	@Column(name="description")
	private String desc;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "category")
	private Set<Product> products = new HashSet<>();
	
	
	public void addProduct ( Product product)
	{	
		products.add(product);
		product.setCategory(this);
	}
	public void removeProduct(Product product)
	{
		products.remove(product);
		product.setCategory(null);
	}
}
