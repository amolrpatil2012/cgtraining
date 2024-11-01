import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import qualifierdemo.config.ProjectConfig;
import qualifierdemo.controller.PersonController;
import qualifierdemo.model.Person;

public class App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext  context = 
				new AnnotationConfigApplicationContext(ProjectConfig.class);
		PersonController personController = context.getBean(PersonController.class);
		personController.show("student");
		
		
		
	}
}
