package com.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.demo.bean.Category;
import com.demo.bean.Product;
import com.demo.dao.CategoryDao;
import com.demo.dao.ProductDao;
import com.demo.service.CategorytoProductService;

@Service
public class CategoryToProductServiceImpl implements CategorytoProductService {
	
	@Autowired
	ProductDao pd;

	@Autowired
	CategoryDao cd;

	@Override
	public  Category addCategorytoProduct(int catId, Product p) {
		// TODO Auto-generated method stub
		
		Optional<Category> cat=cd.findById(catId);
		
		if(cat.isPresent()) {
			Category cat2=cat.get();
			p.setCategory(cat2);
			List<Product> plist=cat2.getListProduct(); 
            cat2.getListProduct().add(p);
           
			return cd.save(cat2);
		}
		
		return null;
	}

	@Override
	public Product getByIdCategoryToProduct(int catId, int pid) {
		// TODO Auto-generated method stub
		Optional<Category> cat = cd.findById(catId);

		if (cat.isPresent()) {
			Category cat2 = cat.get();
			List<Product> plist=cat2.getListProduct();
			
			for(Product p:plist) {
				if(p.getPid()==pid) {
					return p;
				}
			}
			
		}

		return null;
	}

	@Override
	public List<Product> getAllProductCategoryToProduct(int catId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Optional<Category> cat = cd.findById(catId);
				
				if (cat.isPresent()) {
					Category cat2 = cat.get();
					List<Product> plist=cat2.getListProduct();
					return plist;
				}

		return null;
	}

	@Override
	public void deleteByIdProductCategoryToProduct(int catId, int pid) {
		// TODO Auto-generated method stub
		Optional<Category> cat = cd.findById(catId);

		if (cat.isPresent()) {
			Category cat2 = cat.get();
			List<Product> plist=cat2.getListProduct();
			
			for(Product p:plist) {
				if(p.getPid()==pid) {
					plist.remove(p);
					pd.deleteById(pid);
				  
				}
			}
			cd.save(cat2);
		}

		

	}

	@Override
	public void updateByIdProductCategoryToProduct(int catId,int pid, Product p) {
		// TODO Auto-generated method stub
		
		Optional<Category> cat = cd.findById(catId);

		if (cat.isPresent()) {
			Category cat2 = cat.get();
			List<Product> plist=cat2.getListProduct();
			
			for(Product prod:plist) {
				
				if(prod.getPid()==pid) {
					prod.setPname(p.getPname());
					prod.setPrice(p.getPrice());
				}
			}
			cd.save(cat2);
		}

	}

}
