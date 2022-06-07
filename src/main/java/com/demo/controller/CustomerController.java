package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;

import com.demo.model.CustomerDetails;
import com.demo.model.ProductDetails;
import com.demo.service.DemoService;

@RestController
public class CustomerController {

	@Autowired
	DemoService service;
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	//json object for api response
	JSONObject response = new JSONObject();
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	public ResponseEntity<JSONObject> registerUser(@RequestBody CustomerDetails user){
		try {
			logger.info("\n*****Calling User registering API*****");
			response.keySet().clear(); //clearing response object
			List<CustomerDetails> users = service.findUsersByemail(user.getEmail());
			logger.debug("existing users--->"+users);
			if(users.size()==0) {
				service.saveCustomer(user);
				response.put("response", "User registered Successfully");
				response.put("Data", user);
				logger.info(user.getName()+" User registered Successfully");
				return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			}
			response.put("response", "User already exists.");
			response.put("Data", user);
			logger.info(user.getName()+" User already exists");
			return new ResponseEntity<JSONObject>(response, HttpStatus.CONFLICT);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			response.put("response","Internal errors");
			return new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
    public ResponseEntity<JSONObject> loginUser(@RequestBody CustomerDetails user) {
		try {
			response.keySet().clear(); //clearing response object
	        List<CustomerDetails> users = service.findAllCustomer();
	        logger.info("\n********User Login API calling*******");
	        for (CustomerDetails other : users) {
	            if ((other.getEmail().equals(user.getEmail()))&&
	            		(other.getPassword().equals(user.getPassword()))) {
	            		logger.info("Login successfully for user "+other.getName());
	            		other.setStatus("active");
	            		response.put("Status", "success");
	            		response.put("Data", other);
	            		return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
	            }
	        }
	        response.put("Status", "failed");
			response.put("Data", user);
	        return new ResponseEntity<JSONObject>(response, HttpStatus.UNAUTHORIZED);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			response.put("response","Internal errors");
			return new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/user/logout",method=RequestMethod.POST)
	public ResponseEntity<JSONObject> logOutUser(@RequestBody CustomerDetails user){
		response.keySet().clear();
		try {
			if(user!=null) {
				user.setStatus("inactive");
        		logger.info("Logged Out successfully for user "+user.getName());
        		response.put("Status", "success");
        		response.put("Data", user);
        		return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			}
			response.put("Status", "failed");
			response.put("Data", user);
	        return new ResponseEntity<JSONObject>(response, HttpStatus.UNAUTHORIZED);

		}
		catch(Exception ex) {
			ex.printStackTrace();
			response.put("response","Internal errors");
			return new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/users",method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDetails>> findAllCustomer() {	
		List<CustomerDetails> data = new ArrayList<>();
		try {
			response.keySet().clear();
			logger.info("Fetching all customers information");
			data = service.findAllCustomer();
			logger.debug("data"+data);
			return new ResponseEntity<List<CustomerDetails>>(data, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();		
			return new ResponseEntity<List<CustomerDetails>>(data,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/user/search",method=RequestMethod.POST)
	public ResponseEntity<List<ProductDetails>> searchProductByname(@RequestParam("search")
			String search){
		List<ProductDetails> data = new ArrayList<>();
		try {
			logger.info("Fetching all prodcts information");
			data=service.findByKeyword(search);
			return new ResponseEntity<List<ProductDetails>>(data, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();		
			return new ResponseEntity<List<ProductDetails>>(data,HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
