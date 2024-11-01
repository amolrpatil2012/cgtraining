package cg.anndemo.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// Java Bean

public class Student {

		int roll;
		String name;
		Address address;				// inner bean
		
		
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public int getRoll() {
			return roll;
		}
		public void setRoll(int roll) {
			this.roll = roll;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Student()
		{
			System.out.println("Student Bean created");
		}
		@Override
		public String toString() {
			return "Student [roll=" + roll + ", name=" + name + ", address=" + address + "]";
		}
		
		// contains initialization operations
		@PostConstruct
		public void init()
		{
			System.out.println("Inside Init Method in Student class");
		}
		
		// contains destroy operations
		@PreDestroy
		public void destroy()
		{
			System.out.println("Inside destroy method in Student class");
		}
		
		
		
		
}
