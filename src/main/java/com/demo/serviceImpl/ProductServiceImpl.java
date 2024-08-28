package com.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.demo.bean.Product;
import com.demo.dao.ProductDao;
import com.demo.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao pd;
	
	@Override
	public Product createProduct(Product prod) {
		// TODO Auto-generated method stub
		return pd.save(prod);
	}

	@Override
	public Product getByIdProduct(int id) {
		// TODO Auto-generated method stub
		return pd.findById(id).orElse(null);
	}

	@Override
	public List<Product> getAllProducts(int pageNo) {
		// TODO Auto-generated method stub
		PageRequest pageRequest=PageRequest.of(pageNo, 5);
		Page<Product> pagelist=pd.findAll(pageRequest);
		List<Product> plist=pagelist.getContent();
		
		return plist;
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		pd.deleteById(id);

	}

	@Override
	public void updateProduct(int id,Product prod) {
		// TODO Auto-generated method stub
		
		Optional<Product> p=pd.findById(id);
		
		if(p.isPresent()) {
			
			Product p2=p.get();
			
			p2.setPname(prod.getPname());
			p2.setPrice(prod.getPrice());
			p2.setCategory(prod.getCategory());
			
			pd.save(p2);
		}
		
		

	}

}
