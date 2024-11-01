import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lookupdemo.ProjectConfig;
import lookupdemo.User;

public class App {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ProjectConfig.class);
		User user = context.getBean(User.class);
		System.out.println(user.assignRole("Admin"));
		System.out.println(user.assignRole("User"));
	}

}
