package cg.annotationdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cg.annotationdemo.beans.Student;
import cg.annotationdemo.config.ProjectConfig;
import cg.annotationdemo.service.MessageService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =
        		new AnnotationConfigApplicationContext(ProjectConfig.class);
       
        	MessageService ms = context.getBean(MessageService.class);
        	ms.sendMessage("Hello");
        
//        Student student =(Student) context.getBean("rohit");
//        System.out.println(student);
//        //System.out.println(student.hashCode());
//        
//        Student student1 = context.getBean(Student.class);
//        System.out.println(student1.hashCode());
    }
}






