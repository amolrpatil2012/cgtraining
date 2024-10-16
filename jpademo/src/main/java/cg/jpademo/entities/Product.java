package cg.jpademo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity							// compulsory
@Table ( name = "products")		// not compulsory
public class Product {
	
	@Id							// to define primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	
	private int pid;	// will generate id values as auto increment
	
	@Column(name="productname",nullable = false , unique=true)
	private String pname;
	private double price;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "detailsid")
	private ProductDetails details;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name = "catid")
	Category category;
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
		category.addProduct(this);
	}
	public ProductDetails getDetails() {
		return details;
	}
	public void setDetails(ProductDetails details) {
		this.details = details;
	}
	public Product()
	{
		
	}
	public Product( String pname, double price) {
		super();
		
		this.pname = pname;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
