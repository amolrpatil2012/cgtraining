package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;
@Repository
public class StudentRepo {

	List<Student> students = new ArrayList<Student>();
	
	public StudentRepo()
	{
		students.add(new Student(1,"Rohit"));
		students.add(new Student(2,"Virat"));
		students.add(new Student(3,"Rishabh"));
	}
	
	public List<Student> findAll()
	{
		return students;
	}
	
	public Student findByRoll ( int roll)
	{
		return students
				.stream()
				.filter(s->s.getRoll()==roll)
				.findFirst()
				.get();
	}
	public void addStudent ( Student student)
	{
		students.add(student);
	}
	public void deleteByRoll ( int roll)
	{
			Student s = findByRoll(roll);
			students.remove(s);		
	}
	
	public Student update ( int roll , Student newStudent)
	{
			Student oldStudent = findByRoll(roll);
			oldStudent.setName(newStudent.getName());
			return newStudent;
	}
	
	
}
