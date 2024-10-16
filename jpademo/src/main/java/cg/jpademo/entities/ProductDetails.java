package cg.jpademo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class ProductDetails {

	@Id
	int pdid;
	@Override
	public String toString() {
		return "ProductDetails [pdid=" + pdid + ", description=" + description + ", manufacturer=" + manufacturer + "]";
	}

	String description , manufacturer;
	public int getPdid() {
		return pdid;
	}
	public void setPdid(int pdid) {
		this.pdid = pdid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public ProductDetails(int pdid, String description, String manufacturer) {
		super();
		this.pdid = pdid;
		this.description = description;
		this.manufacturer = manufacturer;
	}
	
	public ProductDetails() {}
}
