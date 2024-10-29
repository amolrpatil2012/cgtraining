package com.example.jpacrud.service;

import java.util.List;

import com.example.jpacrud.dto.EmpDto;
import com.example.jpacrud.entities.Emp;

public interface EmpService {
	
	String saveEmp ( Emp emp);
	List<EmpDto> findAll();
	Emp findById ( long empid);
	Emp update ( Emp newEmp , long empid);
	String delete ( long empid);
	List<Emp> findBySalary ( int salary);
	List<Emp> findByNameStartingWith ( String start);

}
