package com.example.jpacrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpacrud.entities.Emp;
import com.example.jpacrud.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	EmpService service;
	
	//http://localhost:8080/emps
	@PostMapping("/emps")
	public String saveEmp ( @RequestBody Emp emp)
	{
			return service.saveEmp(emp);
	}
	

	// http://localhost:8080/emps
	@GetMapping("/emps")
	public List<Emp> getAllEmps()
	{
		return service.findAll();
	}
	// http://localhost:8080/emps/1
	@GetMapping("/emps/{id}")
	public Emp findById(@PathVariable long id)
	{
		return service.findById(id);
	}
	// http://localhost:8080/emps/1
	@DeleteMapping("/emps/{id}")
	public String deleteById ( @PathVariable long id)
	{
		return service.delete(id);
	}
	// http://localhost:8080/emps/1
	@PutMapping("/emps/{id}")
	public Emp update ( @RequestBody Emp emp , @PathVariable long id)
	{
			return service.update(emp, id);
	}
	
	
	
	
	
	
}
