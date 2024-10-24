package com.example.demo.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @RestController ---> @Controller + @ResponseBody
@RestController
public class HelloController {
	
	//http://localhost:8080/hello
	@GetMapping("/hello")
	//@ResponseBody
	public String getHello()
	{
		return "Hello World";
	}
	
	@GetMapping("/welcome")
	//@ResponseBody
	public String getWelcome()
	{
		return "Welcome";
	}

}
