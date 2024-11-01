import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import annotationsdemo.model.PropertySourceDemo;
import annotationsdemo.model.Student;

@Configuration
@ComponentScan(basePackages = {"annotationsdemo.model"})
@PropertySource(value = "personal.properties")
@PropertySource(value = "school.properties")


public class App {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(App.class);
		
		Student student = context.getBean(Student.class);
		System.out.println(student.getName());
		System.out.println(student.getRoll());
		PropertySourceDemo d = context.getBean(PropertySourceDemo.class);
		System.out.println(d.getAge());
		System.out.println(d.getName());
		System.out.println(d.getSchoolname());
		
		System.out.println(student.getName());
	}

}
