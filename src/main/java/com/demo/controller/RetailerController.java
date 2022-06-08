package com.demo.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.CustomerDetails;
import com.demo.model.ProductDetails;
import com.demo.model.RetailerDetails;
import com.demo.service.AuthenticationService;
import com.demo.service.ProductService;

@RestController
public class RetailerController {

	@Autowired
	ProductService productservice;
	
	@Autowired
	AuthenticationService authservice;
	
	Logger logger = LoggerFactory.getLogger(RetailerController.class);
	
	//json object for api response
	JSONObject response = new JSONObject();
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/retailer/register",method=RequestMethod.POST)
	public ResponseEntity<JSONObject> registerRetailer(@RequestBody RetailerDetails retailer){
		try {
			logger.info("\n*****Calling retailer registering API*****");
			response.keySet().clear(); //clearing response object
			RetailerDetails users = authservice.findRetailersByemail(retailer.getEmail());
			logger.debug("existing retailer--->"+users);
			if(users!=null) {
				authservice.saveRetailer(retailer);
				response.put("response", "Retailer registered Successfully");
				response.put("Data", retailer);
				logger.info(retailer.getName()+" Retailer registered Successfully");
				return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			}
			response.put("response", "Retailer already exists.");
			response.put("Data", retailer);
			logger.info(retailer.getName()+" Retailer already exists");
			return new ResponseEntity<JSONObject>(response, HttpStatus.CONFLICT);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			response.put("response","Internal errors");
			return new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/retailer/login",method=RequestMethod.POST)
    public ResponseEntity<JSONObject> loginRetailer(@RequestBody RetailerDetails retailer) {
		try {
			response.keySet().clear(); //clearing response object
	        List<RetailerDetails> retailers = authservice.findAllRetailer();
	        logger.info("\n********Retailer Login API calling*******");
	        for (RetailerDetails other : retailers) {
	            if ((other.getEmail().equals(retailer.getEmail()))&&
	            		(other.getPassword().equals(retailer.getPassword()))) {
	            		logger.info("Login successfully for retailer "+other.getName());
	            		other.setStatus("active");
	            		response.put("Status", "success");
	            		response.put("Data", other);
	            		return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
	            }
	        }
	        response.put("Status", "failed");
			response.put("Data", retailer);
	        return new ResponseEntity<JSONObject>(response, HttpStatus.UNAUTHORIZED);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			response.put("response","Internal errors");
			return new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/retailer/logout",method=RequestMethod.POST)
	public ResponseEntity<JSONObject> logOutRetailer(@RequestBody RetailerDetails retailer){
		response.keySet().clear();
		try {
			if(retailer!=null) {
				retailer.setStatus("inactive");
        		logger.info("Logged Out successfully for retailer "+retailer.getName());
        		response.put("Status", "success");
        		response.put("Data", retailer);
        		return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			}
			response.put("Status", "failed");
			response.put("Data", retailer);
	        return new ResponseEntity<JSONObject>(response, HttpStatus.UNAUTHORIZED);

		}
		catch(Exception ex) {
			ex.printStackTrace();
			response.put("response","Internal errors");
			return new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/retailer/addproduct",method=RequestMethod.POST)
	public ResponseEntity<JSONObject> addProduct(@RequestBody ProductDetails product){
		try {
			logger.info("\n*****Calling API for adding product*****");
			response.keySet().clear(); //clearing response object
			if(product!=null) {
				productservice.saveProducts(product);
				response.put("response", "Product added Successfully");
				response.put("Data", product);
				logger.info(product.getProduct_name()+" added Successfully");
				return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			}
			response.put("response", "failed to add product.Please check the data again.");
			response.put("Data", product);
			logger.info(product.getProduct_name()+" failed to add product.Please check the data again.");
			return new ResponseEntity<JSONObject>(response, HttpStatus.CONFLICT);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			response.put("response","Internal errors");
			return new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
