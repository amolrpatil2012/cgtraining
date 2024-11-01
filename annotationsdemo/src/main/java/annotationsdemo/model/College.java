package annotationsdemo.model;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("student")
public class College {
	
	String collegeName;
	
	public College()
	{
		System.out.println("College Bean Created");
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	

}
