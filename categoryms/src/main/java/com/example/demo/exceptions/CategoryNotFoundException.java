package com.example.demo.exceptions;

public class CategoryNotFoundException extends RuntimeException{

	public CategoryNotFoundException(String msg)
	{
		super(msg);
	}
}
