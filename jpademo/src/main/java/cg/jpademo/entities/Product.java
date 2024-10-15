package cg.jpademo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
