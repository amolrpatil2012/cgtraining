package com.example.demo.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	// http://localhost:8080/students
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		return service.findAll();
	}

	// http://localhost:8080/students/2 <--- path variable
	@GetMapping("/students/{roll}")
	public Student getStudentByRoll (@PathVariable int roll )
	{
		return service.findByRoll(roll);
	}
	
	// http://localhost:8080/students
	@PostMapping ( "/students")
	public String save ( @RequestBody Student student)
	{
		service.addStudent(student);
		return "Data Added Successfully";
	}
	
	// http://localhost:8080/students/2 <--- path variable
		@DeleteMapping("/students/{roll}")
		public String deleteStudent(@PathVariable int roll )
		{
			 service.removeStudent(roll);
			 return "Student deleted successfully!!";
		}
		
		
	// http://localhost:8080/students/2 <--- path variable
	@PutMapping("/students/{roll}")
	public Student updateStudent(@PathVariable int roll , @RequestBody Student student)
	{
			return service.updateStudent(roll, student);
	}
	
	
}
