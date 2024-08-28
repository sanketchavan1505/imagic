package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.Category;
import com.demo.dao.CategoryDao;
import com.demo.service.CategoryService;

@RestController
@RequestMapping("/api/Categories")
public class CategoryController {
	@Autowired
	CategoryService cs;
	
	public CategoryController() {
		// TODO Auto-generated constructor stub
		System.out.println("Hello category controller is called......");
	}
	
	
	@GetMapping("")
	public List<Category> getAllCategories(@Param("page") int page){
		return cs.getAllCategories(page);
	}
	
	@GetMapping("/{id}")
	public Category getByIdCategory(@PathVariable int id) {
		return cs.getByIdCategory(id);
	}
	
	@PostMapping("")
	public Category createCategory(@RequestBody Category cat) {
		return cs.createCategory(cat);
	}
	
	@PutMapping("/{id}")
	public String updateCategory(@PathVariable int id,@RequestBody Category cat) {
		cs.updateCategory(id, cat);
		
		return "Category updated successfully.....";
	}
	
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable int id) {
		cs.deleteCategory(id);
		
		return "Product deleted successfully....";
				
	}
	
	
	
	

}
