package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductResponseDto;
import com.example.demo.entities.Product;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repo.ProductRepo;




@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	@Autowired
	APIClient apiClient;

	
	@Override
	public ProductDto save(ProductDto productDto) {
		Product newProduct = repo.save( ProductMapper.productDtoToProduc(productDto));
		return ProductMapper.productToProductDto(newProduct);
		
	}

	@Override
	public List<ProductDto> findAll() {
		// TODO Auto-generated method stub
		List<Product> pds =  repo.findAll();
		List<ProductDto> dtos = new ArrayList<ProductDto>();
		pds.forEach(p->dtos.add(ProductMapper.productToProductDto(p)));
		return dtos;
	}

	@Override
	public ProductDto findById(long id) {
		// TODO Auto-generated method stub
		
		Product pd = repo.findById(id).orElseThrow(()->new ProductNotFoundException("Product Not Found"));
		return ProductMapper.productToProductDto(pd);
	}

	@Override
	public String delete(long id) {
		ProductDto pDto = findById(id);
		Product product = ProductMapper.productDtoToProduc(pDto);
		repo.delete(product);
		return "Product deleted Successfully!!";
	}

	@Override
	public ProductDto update(long id, ProductDto newProduct) {
		ProductDto pd = findById(id);
		Product product = ProductMapper.productDtoToProduc(pd);
		product.setName(newProduct.getName());		
		product.setPrice(newProduct.getPrice());
		repo.save(product);
		return pd;
	}

	public ProductResponseDto getProductInfo(long id)
	{
		ProductDto pd = findById(id);
		Product p = ProductMapper.productDtoToProduc(pd);
		
			CategoryDto categoryDto = apiClient.getCategory(p.getCatid());
			ProductResponseDto pdto = ProductMapper.productToProductResponseDto(p, categoryDto);
			return pdto;
	}



}
