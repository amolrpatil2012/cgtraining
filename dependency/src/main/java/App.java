import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dependency.example.beans.Person;
import dependency.example.config.ProjectConfig;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ProjectConfig.class);
		Person person = context.getBean(Person.class);
		System.out.println(person.getName());
		System.out.println(person.getVehicle().getName());
		person.getVehicle().getServices().info();
		
	}
}
