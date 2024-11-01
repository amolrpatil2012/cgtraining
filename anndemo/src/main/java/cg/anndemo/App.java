package cg.anndemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cg.anndemo.beans.Emp;
import cg.anndemo.beans.MessageProcessor;
import cg.anndemo.beans.Person;
import cg.anndemo.beans.Student;
import cg.anndemo.config.ProjectConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Starting IOC Container");
    	ApplicationContext ioccontainer = new AnnotationConfigApplicationContext(ProjectConfig.class);
    	//Student s = ioccontainer.getBean(Student.class);
//    	Student s = (Student) ioccontainer.getBean("rohit");
//    	System.out.println(s);
    	
    	//Emp emp = ioccontainer.getBean(Emp.class);		// can not set initial properties cause created using @Component annotation
//    	Emp emp = (Emp) ioccontainer.getBean("empbean");
//    	emp.setName("Rohit");
//    	emp.setSalary(40000);
//    	System.out.println(emp);

    	
    	// e1 and e2 will refer to two separate objects if scope is Prototype
    	// e1 and e2 will refer to same objects if scope is Singleton
    	
//    	Emp e1 = ioccontainer.getBean(Emp.class);
//    	System.out.println("Hash Code of Emp Object" + e1.hashCode());
//    	Emp e2 = ioccontainer.getBean(Emp.class);
//    	System.out.println("Hash Code of Emp Object" + e2.hashCode());
//    	
    	
    	
    	//Emp emp = ioccontainer.getBean(Emp.class);	
    	
    	//MessageProcessor processor = ioccontainer.getBean(MessageProcessor.class);
    	//processor.handleMsg(" Hello ");
    	
    	Person p = ioccontainer.getBean(Person.class);
    	System.out.println(p.getName());
    	System.out.println(p.getAge());
    	System.out.println(p.getCountry());
    	System.out.println("Closing IOC Container");
    	((ConfigurableApplicationContext)ioccontainer).close();
    			
    	
    	
    	
    }
}
