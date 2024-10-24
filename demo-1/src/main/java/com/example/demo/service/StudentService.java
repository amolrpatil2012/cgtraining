package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {

	StudentRepo repo;
	//@Autowired
	public StudentService(StudentRepo repo) {
		super();
		this.repo = repo;
	}
	
	public List<Student> findAll()
	{
		return repo.findAll();
	}
	public Student findByRoll ( int roll)
	{
		return repo.findByRoll(roll);
	}
	public void addStudent ( Student student )
	{
		repo.addStudent(student);
	}
	public void removeStudent ( int roll)
	{
		repo.deleteByRoll(roll);
	}
	public Student updateStudent ( int roll , Student newStudent)
	{
		return repo.update(roll, newStudent);
	}
}
