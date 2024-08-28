package com.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.demo.bean.Category;
import com.demo.bean.Product;
import com.demo.dao.CategoryDao;
import com.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao cd;
	
	@Override
	public List<Category> getAllCategories(int pageNo) {
		// TODO Auto-generated method stub

		PageRequest pagerequest=PageRequest.of(pageNo, 1);
		
		Page<Category> page=cd.findAll(pagerequest);
		List<Category> categories=page.getContent();
		return categories;
	}

	@Override
	public Category getByIdCategory(int id) {
		// TODO Auto-generated method stub
		return cd.findById(id).orElse(null);
	}

	@Override
	public Category createCategory(Category cat) {
		// TODO Auto-generated method stub
		return cd.save(cat);
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		cd.deleteById(id);

	}

	@Override
	public void updateCategory(int id,Category cat) {
		// TODO Auto-generated method stub
		
		Optional<Category> cat1=cd.findById(id);
		
		if(cat1.isPresent()) {
			
			Category cat2=cat1.get();
			
			cat2.setCatName(cat.getCatName());
			cat2.setListProduct(cat.getListProduct());
			
			cd.save(cat2);
		}

	}

	

}
