package cg.annotationdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cg.annotationdemo.beans.Student;


// contains all information related to beans configuration

@Configuration
@ComponentScan(basePackages = {"cg.annotationdemo.beans","cg.annotationdemo.service"})
public class ProjectConfig {
	
	@Bean("rohit")
	public Student getStudent1()
	{
		return new Student ( 10 , "Rohit" );
	}
	
	@Bean("virat")
	public Student getStudent2()
	{
		return new Student ( 11 , "Virat" );
	}

}
