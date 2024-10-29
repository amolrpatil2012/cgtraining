//package com.example.jpacrud.exceptions;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalEx {
//	
//	@ExceptionHandler(EmpNotFoundException.class)
//	public ResponseEntity<ErrorDetails> handleEmpNotFoundException
//	( EmpNotFoundException ex)
//	{
//		ErrorDetails ed = new ErrorDetails();
//		ed.setMessage(ex.getMessage());
//		ed.setStatusCode(HttpStatus.NOT_FOUND.value());
//		
//		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.NOT_FOUND);
//	}
//
//}
