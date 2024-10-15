package cg.jpademo;

import cg.jpademo.entities.Product;
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
//    	ps.addProduct(p1);
//    	
//    	ps.addProduct(new Product("Mobile" , 10000));
//    	ps.addProduct(new Product("Camera" , 5000));
    	
    	//System.out.println(ps.findById(2));
    	ps.findAllProducts().forEach(System.out::println);
    }
}
