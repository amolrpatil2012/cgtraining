package com.example.jpacrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpacrud.entities.Emp;

public interface EmpRepo extends JpaRepository<Emp, Long> {

}
