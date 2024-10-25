package com.example.jpacrud.service;

import java.util.List;

import com.example.jpacrud.entities.Emp;

public interface EmpService {
	
	String saveEmp ( Emp emp);
	List<Emp> findAll();
	Emp findById ( long empid);
	Emp update ( Emp newEmp , long empid);
	String delete ( long empid);

}
