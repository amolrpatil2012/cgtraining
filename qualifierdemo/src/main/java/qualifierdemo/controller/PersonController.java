package qualifierdemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import qualifierdemo.model.Person;

@Component
public class PersonController {

	
	
	
	Map<String,Person> persons;
	@Autowired
	public PersonController(Map<String,Person> persons)
	{
		this.persons = persons;
	}
	
	
	public void show(String personType)
	{
		Person person = persons.get(personType) ;
		System.out.println(person.getName());
	}
	
	
}
