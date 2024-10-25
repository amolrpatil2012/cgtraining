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

	@Override
	public Emp update(Emp newEmp, long empid) {
		// TODO Auto-generated method stub
		Emp oldEmp = findById(empid);
		oldEmp.setName(newEmp.getName());
		oldEmp.setSalary(newEmp.getSalary());
		return null;
	}

	@Override
	public String delete(long empid) {
		Emp emp = findById(empid);
		repo.delete(emp);
		return "Deleted Successfully";
		
	}

	@Override
	public Emp findById(long empid) {
		// TODO Auto-generated method stub
		return repo.findById(empid).orElseThrow(()->new RuntimeException("Not Found"));
	}

}
