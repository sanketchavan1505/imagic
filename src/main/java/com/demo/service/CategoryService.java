package com.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.bean.Category;

public interface CategoryService {
	
	public List<Category> getAllCategories(int pageNo);
	
	public Category getByIdCategory(int id);
	
	public Category createCategory(Category cat);
	
	public void deleteCategory(int id);
	
	public void updateCategory(int id,Category cat);

}
