package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.ProductDetails;
import com.demo.repository.ProductDetailsRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductDetailsRepo productsrepo;
		
	public List<ProductDetails> findByKeyword(String search){
		return productsrepo.findByKeyword(search);
	}
	public void saveProducts(ProductDetails product) {
		productsrepo.save(product);
	}
}
