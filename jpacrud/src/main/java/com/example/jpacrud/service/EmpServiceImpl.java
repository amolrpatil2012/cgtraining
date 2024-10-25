package com.example.jpacrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpacrud.entities.Emp;
import com.example.jpacrud.repo.EmpRepo;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpRepo repo;	
	
	@Override
	public String saveEmp(Emp emp) {		
		repo.save(emp);
		return "Data Saved Successfully";		
	}

	@Override
	public List<Emp> findAll() {
		return repo.findAll();
	}

}
