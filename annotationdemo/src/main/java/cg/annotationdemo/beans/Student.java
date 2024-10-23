package cg.annotationdemo.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//
//@Component
//@Scope(value = "prototype")
public class Student {
	
	public Student()
	{
		
	}
	public Student(int roll, String name) {
		super();
		this.roll = roll;
		this.name = name;
	}
	int roll;
	String name;
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
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + "]";
	}
	
	

}
