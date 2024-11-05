package cg.products.productrest.mapper;

import cg.products.productrest.dto.ProductResponseDto;
import cg.products.productrest.entities.Product;

public class ProductMapper {

	public static ProductResponseDto productToProudctResponseDto ( Product product)
	{
		ProductResponseDto pd = new ProductResponseDto();
		pd.setPid(product.getPid());
		pd.setCategory(product.getCategory().getCatname());
		pd.setName(product.getName());
		pd.setPrice(product.getPrice());
		return pd;
	}
}
