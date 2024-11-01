package dependency.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

	String name = "Honda";
	@Autowired
	VehicleServices services;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public VehicleServices getServices() {
		return services;
	}
	public void setServices(VehicleServices services) {
		this.services = services;
	}
	
	
	
}
