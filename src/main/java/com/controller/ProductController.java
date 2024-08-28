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

import com.demo.bean.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/api/Products")
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	public ProductController() {
		// TODO Auto-generated constructor stub
		System.out.println("Hello Product Controller is called.....");
	}
	
	@GetMapping("")
	public List<Product>  getAllProduct(@Param("page") int page){
		return ps.getAllProducts(page);
	}
	
	@GetMapping("/{id}")
	public Product getByIdProduct(@PathVariable int id) {
		return ps.getByIdProduct(id);
	}
	
	@PostMapping("")
	public Product createProduct(@RequestBody Product prod) {
		return ps.createProduct(prod);
	}
	
	@PutMapping("/{id}")
	public String updateProduct(@PathVariable int id,@RequestBody Product prod) {
		ps.updateProduct(id, prod);
		
		return "Product update successfully.......";
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
		ps.deleteProduct(id);
		
		return "Product deleted successfully......";
	}

}
