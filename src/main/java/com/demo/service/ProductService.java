package com.demo.service;

import java.util.List;

import com.demo.bean.Product;

public interface ProductService {

	
	public Product createProduct(Product prod);
	
	public Product getByIdProduct(int id);
	
	public List<Product> getAllProducts(int pageNo);
	
	public void deleteProduct(int id);
	
	public void updateProduct(int id,Product prod);
}
