package com.example.jpacrud.mapper;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import com.example.jpacrud.dto.EmpDto;
import com.example.jpacrud.entities.Emp;

@Component
public class EmpMapper {

	public static EmpDto empToEmpDtp ( Emp emp )
	{
		EmpDto dto = new EmpDto();
		dto.setName(emp.getName());
		dto.setEmail(emp.getDetails().getEmail());
		dto.setMnumber(emp.getDetails().getMnumber());
		dto.setSalary(emp.getSalary());
		return dto;
	}
}
