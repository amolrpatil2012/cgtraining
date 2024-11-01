package cg.anndemo.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Will create a bean and register with container
@Component	(value="empbean")		
@Lazy
//@Scope("prototype")
public class Emp {

	@Override
	public String toString() {
		return "Emp [name=" + name + ", salary=" + salary + "]";
	}
	String name;
	int salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Emp()
	{
		System.out.println("Emp Bean Created");
	}
	
}
