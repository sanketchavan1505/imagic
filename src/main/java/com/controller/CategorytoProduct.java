package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.Category;
import com.demo.bean.Product;
import com.demo.service.CategorytoProductService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/CatToProd")
public class CategorytoProduct {
	
	@Autowired
	CategorytoProductService ctps;
	
	
	public CategorytoProduct() {
		// TODO Auto-generated constructor stub
		System.out.println("Category to Product controller is called.....");
	}
	
	@PostMapping("/{catid}")
	public Category  createProductCatToProd(@PathVariable int catid,@RequestBody Product prod) {
		return ctps.addCategorytoProduct(catid, prod);
	}
	
	@GetMapping("/{catid}")
	public List<Product> getAllProductCatToProd(@PathVariable int catid){
		return ctps.getAllProductCategoryToProduct(catid);
	}
	
	@GetMapping("/{catid}/{pid}")
	public Product getByIdProductCatToProd(@PathVariable int catid,@PathVariable int pid){
		return ctps.getByIdCategoryToProduct(catid,pid);
	}
	
	@DeleteMapping("/{catid}/{pid}")
	public String deleteByIdProductCatToProd(@PathVariable int catid,@PathVariable int pid){
		 ctps.deleteByIdProductCategoryToProduct(catid,pid);
		 return "Delete Product Successfully.....";
	}
	
	@PutMapping("/{catid}/{pid}")
	public String UpdateProductCatToProd(@PathVariable int catid,@PathVariable int pid,@RequestBody Product p){
		 ctps.updateByIdProductCategoryToProduct(catid,pid,p);
		 return "Update Product Successfully.....";
	}

}
