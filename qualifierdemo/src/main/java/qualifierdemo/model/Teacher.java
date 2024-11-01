package qualifierdemo.model;

import org.springframework.stereotype.Component;

@Component("teacher")
public class Teacher implements Person {

	public String getName() {
		// TODO Auto-generated method stub
		return "I am Teacher";
	}
	
	

}
