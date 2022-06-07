package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.CustomerDetails;
import com.demo.model.ProductDetails;
import com.demo.model.RetailerDetails;
import com.demo.repository.CustomerDetailsRepo;
import com.demo.repository.ProductDetailsRepo;
import com.demo.repository.RetailerDetailsRepo;

@Service
public class DemoService {

	@Autowired
	CustomerDetailsRepo customerrepo;
	
	@Autowired
	RetailerDetailsRepo retailerrepo;
	
	@Autowired
	ProductDetailsRepo productsrepo;
	
	public List<CustomerDetails> findAllCustomer(){
		return customerrepo.findAll();
	}
	
	public void saveCustomer(CustomerDetails user) {
		customerrepo.save(user);
	}
	
	public List<CustomerDetails> findUsersByemail(String email){
		return customerrepo.findUsersByemail(email);
	}
	
	public List<RetailerDetails> findAllRetailer(){
		return retailerrepo.findAll();
	}
	public void saveRetailer(RetailerDetails retailer) {
		retailerrepo.save(retailer);
	}
	public List<RetailerDetails> findRetailersByemail(String email){
		return retailerrepo.findRetailersByemail(email);
	}
	public List<ProductDetails> findByKeyword(String search){
		return productsrepo.findByKeyword(search);
	}
	public void saveProducts(ProductDetails product) {
		productsrepo.save(product);
	}
}
