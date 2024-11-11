package com.example.demo.exceptions;




import java.util.HashMap;


import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;
@RestControllerAdvice
public class GlobalExceptionHandler {

	
	
	
	@ExceptionHandler(value=CategoryNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleCategoryNotFoundException 
	( CategoryNotFoundException ex)
	{
		ErrorDetails error = 
				new ErrorDetails(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgNotValidEx 
	( MethodArgumentNotValidException ex)
	{
		HashMap<String,String> map = new HashMap<String, String>();	
		System.out.println(ex.getAllErrors().size());
		
		ex.getBindingResult().getAllErrors().forEach(e ->{
			
			String field = ((FieldError)e).getField();
			String msg = e.getDefaultMessage();
			
			map.put(field, msg);
		});
		return new ResponseEntity<Object>( map , HttpStatus.BAD_REQUEST);
		
		
		
		
		
	}
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<ErrorDetails> handleException 
	( Exception ex)
	{
		ErrorDetails error = 
				new ErrorDetails(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Object> handleValidation(MethodArgumentNotValidException e)
//	{
//		HashMap<String, String> map = new HashMap<String, String>();
//		e.getBindingResult().getAllErrors().forEach((error)->{
//			
//				String fieldName = ((FieldError)error).getField();
//				String msg = error.getDefaultMessage();
//				map.put(fieldName, msg);
//			
//		});
//		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
//		
//	}
}
