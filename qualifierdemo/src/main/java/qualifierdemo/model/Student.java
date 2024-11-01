package qualifierdemo.model;

import org.springframework.stereotype.Component;

@Component("student")
public class Student  implements Person{

	public String getName() {
		return " I am Student";
	}

}
