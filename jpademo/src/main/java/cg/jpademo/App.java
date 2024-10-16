package cg.jpademo;

import cg.jpademo.entities.Product;
import cg.jpademo.entities.ProductDetails;
import cg.jpademo.service.ProductService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ProductService ps = new ProductService();
    	
//    	Product p1 = new Product("Desktop" , 20000);
//    	ProductDetails pd = 
//    			new ProductDetails(345,"Best Desktop" , "HP");
//    	p1.setDetails(pd);
//     	ps.addProduct(p1);
    	
    	Product p = ps.findById(1);
    	
    	System.out.println("Product : " + p);
    	System.out.println("Details : " + p.getDetails());
    	
    	
    }
}
