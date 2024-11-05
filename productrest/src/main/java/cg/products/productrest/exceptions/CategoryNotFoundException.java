package cg.products.productrest.exceptions;

public class CategoryNotFoundException extends RuntimeException{

	public CategoryNotFoundException(String msg)
	{
		super(msg);
	}
}
