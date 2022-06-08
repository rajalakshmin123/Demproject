package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.CustomerDetails;
import com.demo.model.RetailerDetails;
import com.demo.repository.CustomerDetailsRepo;
import com.demo.repository.RetailerDetailsRepo;

@Service
public class AuthenticationService {
	
	@Autowired
	CustomerDetailsRepo customerrepo;
	
	@Autowired
	RetailerDetailsRepo retailerrepo;
	
	public List<CustomerDetails> findAllCustomer(){
		return customerrepo.findAll();
	}
	
	public void saveCustomer(CustomerDetails user) {
		customerrepo.save(user);
	}
	
	public CustomerDetails findUsersByemail(String email){
		return customerrepo.findUsersByemail(email);
	}
	
	public List<RetailerDetails> findAllRetailer(){
		return retailerrepo.findAll();
	}
	public void saveRetailer(RetailerDetails retailer) {
		retailerrepo.save(retailer);
	}
	public RetailerDetails findRetailersByemail(String email){
		return retailerrepo.findRetailersByemail(email);
	}
}
