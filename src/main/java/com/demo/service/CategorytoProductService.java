package com.demo.service;

import java.util.List;

import com.demo.bean.Category;
import com.demo.bean.Product;

public interface CategorytoProductService {
	
	public Category addCategorytoProduct(int catId,Product p);
	
	public Product  getByIdCategoryToProduct(int catId,int pid);
	
	public List<Product>  getAllProductCategoryToProduct(int catId);
	
	public void deleteByIdProductCategoryToProduct(int catId,int pid);
	
	public void updateByIdProductCategoryToProduct(int catId,int pid,Product p);

}
