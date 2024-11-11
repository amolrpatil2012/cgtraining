package com.example.demo.mapper;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductResponseDto;
import com.example.demo.entities.Product;

public class ProductMapper {

	public static ProductResponseDto productToProductResponseDto ( Product pd , CategoryDto cd)
	{
		ProductResponseDto pdto = new ProductResponseDto();
		pdto.setPid(pd.getPid());
		pdto.setName(pd.getName());
		pdto.setPrice(pd.getPrice());
		pdto.setCatname(cd.getCatname());
		pdto.setCatdesc(cd.getDesc());
		return pdto;
	}
	public static ProductDto productToProductDto ( Product pd)
	{
		ProductDto pdto = new ProductDto();
		pdto.setPid(pd.getPid());
		pdto.setName(pd.getName());
		pdto.setPrice(pd.getPrice());
		return pdto;
	}
	public static Product productDtoToProduc ( ProductDto pdto)
	{
		Product pd = new Product();
		pd.setPid(pdto.getPid());
		pd.setName(pdto.getName());
		pd.setPrice(pdto.getPrice());
		return pd;
	}
	
}
