package com.demo.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bean.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	Page<Product> findByCategoryId(int categoryId, Pageable pageable);
}
