package cg.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.hello.beans.Emp;
import cg.hello.beans.HelloWorld;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =
        		new ClassPathXmlApplicationContext("config.xml");
        
        HelloWorld hello = context.getBean(HelloWorld.class);
        hello.setMessage("Hello World");
        System.out.println(hello.getMessage());
        
        HelloWorld hello1 = context.getBean(HelloWorld.class);
        System.out.println(hello1.getMessage());
        
//        
//        
//        Emp e = context.getBean(Emp.class);
//        System.out.println(e);
        
        
        
    }
}
