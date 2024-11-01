package annotationsdemo.model;

import org.springframework.beans.factory.annotation.Value;


import org.springframework.stereotype.Component;

@Component
public class Student {
	
	@Value("#{10}")
	int roll;
	
	@Value("#{'Rohit'}")
	String name;
	
	public int getRoll() {
		return roll;
	}
	public Student()
	{
		System.out.println("Student Bean Created");
	}
	//@Required
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
