package cg.jpademo;

import cg.jpademo.entities.Category;
import cg.jpademo.entities.Product;
import cg.jpademo.entities.ProductDetails;
import cg.jpademo.service.CategoryService;
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
     	CategoryService cs = new CategoryService();
     	
     	
     	Product product = ps.findById(1);
     	Category category = cs.findById(2);
     	product.setCategory(category);
     	ps.updateProduct(product, 1);
     	
     	
     	
//    	
//    	Product p1 = new Product("Laptop" , 20000);
//    	ProductDetails pd = 
//    			new ProductDetails(1345,"Best Laptop" , "HP");
////    	Category category = cs.findById(2);
////    	p1.setCategory(category);
//    	//category.addProduct(p1);
//    	p1.setDetails(pd);
//     	ps.addProduct(p1);
//    	
//   
//    	Category cat = new Category("Electronics","Electronics");
//    	cs.addCategory(cat);
     	
     	
//    	Product p = ps.findById(1);
//    	
//    	System.out.println("Product : " + p);
//    	System.out.println("Details : " + p.getDetails());
    	
    	
    }
}
