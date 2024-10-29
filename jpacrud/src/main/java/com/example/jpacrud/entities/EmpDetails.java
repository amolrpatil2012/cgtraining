package com.example.jpacrud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp_details")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmpDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Email(message="Invalid Email")
	String email;
	String mnumber;
}
