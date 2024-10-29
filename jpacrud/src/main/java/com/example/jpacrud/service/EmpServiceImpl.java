package com.example.jpacrud.service;

import java.util.ArrayList;
import java.util.List;
import com.example.jpacrud.dto.EmpDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jpacrud.entities.Emp;
import com.example.jpacrud.exceptions.EmpNotFoundException;
import com.example.jpacrud.mapper.EmpMapper;
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
	public List<EmpDto> findAll() {
	
		List<Emp> emps = repo.findAll();
		List<EmpDto> empDtos = new ArrayList<EmpDto>();
		emps.forEach(e->empDtos.add(EmpMapper.empToEmpDtp(e)));
		return empDtos;
	}

	@Override
	public Emp update(Emp newEmp, long empid) {
		// TODO Auto-generated method stub
		Emp oldEmp = findById(empid);
		oldEmp.setName(newEmp.getName());
		oldEmp.setSalary(newEmp.getSalary());
		repo.save(oldEmp);
		return newEmp;
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
		return repo.findById(empid).orElseThrow(()->new EmpNotFoundException("Not Found"));
	}

	@Override
	public List<Emp> findBySalary(int salary) {
		// TODO Auto-generated method stub
		return repo.findBySalary(salary);
	}

	@Override
	public List<Emp> findByNameStartingWith(String start) {
		// TODO Auto-generated method stub
		return repo.findByNameStartingWith(start);
	}

}
