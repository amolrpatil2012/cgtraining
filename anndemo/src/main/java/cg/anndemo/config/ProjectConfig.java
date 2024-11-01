package cg.anndemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import cg.anndemo.beans.Address;
import cg.anndemo.beans.Student;

@Configuration
@ComponentScan(basePackages = {"cg.anndemo.beans"})
@PropertySource(value = "country.properties")
@PropertySource(value = "personal.properties")
public class ProjectConfig {
	
	@Bean(name={"rohit","captain"})						// this will define as a bean [ register with ioc container]
	public Student getStudent()
	{
		Student student = new Student();
		student.setRoll(1);
		student.setName("Rohit");
		student.setAddress(getAddress());
		return student;
	}
	@Bean("virat")													// this will define as a bean [ register with ioc container]
	public Student getStudent1()
	{
		Student student = new Student();
		student.setRoll(2);
		student.setName("Virat");
		return student;
	}
	@Bean
	public Address getAddress()
	{
		Address address = new Address();
		address.setCity("Mumbai");
		address.setCountry("India");
		return address;
	}
}
