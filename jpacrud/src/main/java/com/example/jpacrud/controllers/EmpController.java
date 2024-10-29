package com.example.jpacrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpacrud.dto.EmpDto;
import com.example.jpacrud.entities.Emp;
import com.example.jpacrud.service.EmpService;

import jakarta.validation.Valid;

@RestController
public class EmpController {

	@Autowired
	EmpService service;
	
	//http://localhost:8080/emps
	@PostMapping("/emps")
	public ResponseEntity<String> saveEmp (@Valid @RequestBody Emp emp)
	{
			return new ResponseEntity<String> ( service.saveEmp(emp) , HttpStatus.CREATED );
	}
	
	// http://localhost:8080/emps
	@GetMapping("/emps")
	public ResponseEntity<List<EmpDto>> getAllEmps()
	{
		List<EmpDto> emps = service.findAll();
		ResponseEntity<List<EmpDto>> resp =
				new ResponseEntity<List<EmpDto>>(emps,HttpStatus.OK);
		return resp;
	}
	// http://localhost:8080/emps/1
	@GetMapping("/emps/{id}")
	public ResponseEntity<Emp> findById(@PathVariable long id)
	{
		return new ResponseEntity<Emp>( service.findById(id) , HttpStatus.OK);
	}
	// http://localhost:8080/emps/1
	@DeleteMapping("/emps/{id}")
	public ResponseEntity<String> deleteById ( @PathVariable long id)
	{
		return new ResponseEntity<String>(service.delete(id), HttpStatus.OK);
	}
	// http://localhost:8080/emps/1
	@PutMapping("/emps/{id}")
	public ResponseEntity<Emp> update ( @Valid @RequestBody Emp emp , @PathVariable long id)
	{
			return new ResponseEntity<Emp>(service.update(emp, id),HttpStatus.OK);
	}
	
	//http://localhost:8080/emps/salary/20000
	@GetMapping("/emps/salary/{salary}")
	public ResponseEntity<List<Emp>> findBySalary(@PathVariable int salary)
	{
		return new ResponseEntity<List<Emp>>( service.findBySalary(salary) , HttpStatus.OK);
	}
	
	//http://localhost:8080/emps/byname/Ro
		@GetMapping("/emps/byname/{name}")
		public ResponseEntity<List<Emp>> findByNameStartsWith(@PathVariable String name)
		{
			return new ResponseEntity<List<Emp>>( service.findByNameStartingWith(name) , HttpStatus.OK);
		}
		
		
	
}
