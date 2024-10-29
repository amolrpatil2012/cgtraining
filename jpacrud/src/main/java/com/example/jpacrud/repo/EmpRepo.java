package com.example.jpacrud.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpacrud.entities.Emp;

public interface EmpRepo extends JpaRepository<Emp, Long> {

		List<Emp> findBySalary ( int salary);
		List<Emp> findByNameStartingWith ( String start);
		
		@Query(value = "Select e from Emp e where e.salary < :salary")
		List<Emp> findSalLessThan ( int salary);
}
