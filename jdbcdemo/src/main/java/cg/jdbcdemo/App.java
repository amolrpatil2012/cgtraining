package cg.jdbcdemo;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
//    	Emp e1 = new Emp(1, "Rohit", 40000);
//    	Emp e2 = new Emp(2, "Rahul", 20000);
//    	Emp e3 = new Emp(3, "Virat", 70000);
    	
    	EmpUtility  empUtility = new EmpUtility();
//    	empUtility.addEmp(e1);
//    	empUtility.addEmp(e2);
//    	empUtility.addEmp(e3);
//    	System.out.println("Emps Added Successfully !!");
     
    	
//    	Emp newEmp = new Emp(2, "Rahul", 30000);
//    	empUtility.updateEmp(2, newEmp);
//    	System.out.println("Emp Record updated Successfully !!");
    	
    	//empUtility.deleteEmp(2);
    	System.out.println(empUtility.findEmpsWithSalaryGreaterThan(20000));
    	
    }
}
