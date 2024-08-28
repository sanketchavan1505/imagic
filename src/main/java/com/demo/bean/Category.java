package com.demo.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "Categories")
public class Category {
	@GeneratedValue
	@Id
	private int id;
	private String catName;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	@JsonManagedReference
	List<Product> listProduct;

	public Category() {
		super();
	}

	public Category(int id, String catName, List<Product> listProduct) {
		super();
		this.id = id;
		this.catName = catName;
		this.listProduct = listProduct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", catName=" + catName + ", listProduct=" + listProduct + "]";
	}
	
	

}
