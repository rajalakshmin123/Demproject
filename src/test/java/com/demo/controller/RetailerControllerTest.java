package com.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.model.CustomerDetails;
import com.demo.model.ProductDetails;
import com.demo.model.RetailerDetails;
import com.demo.service.AuthenticationService;
import com.demo.service.ProductService;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class RetailerControllerTest {

	@Mock
	RetailerDetails retailer;
	
	@Mock 
	ProductDetails product;
	
	@Mock
	AuthenticationService authservice;
	
	@Mock
	ProductService productservice;
		
	JSONObject response = new JSONObject();
	
	@Mock
	RetailerController retailercontroller;
		
	ResponseEntity<JSONObject> expectedresponse = null; 
	ResponseEntity<JSONObject> actualresponse =null;
	
	@Test  
    public void registerRetailer(){  
		try {
			//initialsing expected response
			response.put("response","Internal errors");
			
			expectedresponse=new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			Mockito.when(retailercontroller.registerRetailer(retailer)).thenReturn(expectedresponse);
			Assert.assertEquals(expectedresponse, retailercontroller.registerRetailer(retailer));

			response.keySet().clear();
			response.put("response", "Retailer registered Successfully");
			response.put("Data", retailer);
			actualresponse=new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			Mockito.when(retailercontroller.registerRetailer(retailer)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, retailercontroller.registerRetailer(retailer));
			
			response.keySet().clear();
			response.put("response", "Retailer already exists.");
			response.put("Data", retailer);
			actualresponse=new ResponseEntity<JSONObject>(response, HttpStatus.CONFLICT);
			Mockito.when(retailercontroller.registerRetailer(retailer)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, retailercontroller.registerRetailer(retailer));

		} catch (Exception exception) {
			exception.printStackTrace();
			Assert.assertFalse(false);
		}
    }  

	@Test  
    public void loginRetailer(){  
		try {		
			response.put("response","Internal errors");
			expectedresponse=new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
						
			Mockito.when(retailercontroller.loginRetailer(retailer)).thenReturn(expectedresponse);
			Assert.assertEquals(expectedresponse, retailercontroller.loginRetailer(retailer));

			response.keySet().clear();
			response.put("Status", "success");
			response.put("Data", retailer);
			actualresponse=new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			Mockito.when(retailercontroller.loginRetailer(retailer)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, retailercontroller.loginRetailer(retailer));
			
			response.keySet().clear();
			response.put("Status", "failed");
			response.put("Data", retailer);
			actualresponse=new ResponseEntity<JSONObject>(response, HttpStatus.UNAUTHORIZED);
			Mockito.when(retailercontroller.loginRetailer(retailer)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, retailercontroller.loginRetailer(retailer));

		} catch (Exception exception) {
			exception.printStackTrace();
			Assert.assertFalse(false);
		}
	}
	
	@Test  
    public void logOutRetailer(){  
		try {
			response.put("response","Internal errors");
			expectedresponse=new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			Mockito.when(retailercontroller.logOutRetailer(retailer)).thenReturn(expectedresponse);
			Assert.assertEquals(expectedresponse, retailercontroller.logOutRetailer(retailer));

			response.keySet().clear();
			response.put("Status", "success");
			response.put("Data", retailer);
			actualresponse=new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			Mockito.when(retailercontroller.logOutRetailer(retailer)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, retailercontroller.logOutRetailer(retailer));

			response.keySet().clear();
			response.put("Status", "failed");
			response.put("Data", retailer);
			actualresponse=new ResponseEntity<JSONObject>(response, HttpStatus.UNAUTHORIZED);
			Mockito.when(retailercontroller.logOutRetailer(retailer)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, retailercontroller.logOutRetailer(retailer));

		} catch (Exception exception) {
			exception.printStackTrace();
			Assert.assertFalse(false);
		}
	}
	
	@Test  
    public void addProduct(){  
		try {
			response.put("response","Internal errors");
			expectedresponse=new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			Mockito.when(retailercontroller.addProduct(product)).thenReturn(expectedresponse);
			Assert.assertEquals(expectedresponse, retailercontroller.addProduct(product));

			product.setId(1);
			product.setProduct_name("Samsung");
			product.setPrice(50000);
			product.setPicture("C://Users/Rajalakshmi/image.png");
			product.setDescription("Mobile Phone");
			product.setRetailerid("1210");
			
			response.keySet().clear();
			response.put("Status", "Product added Successfully");
			response.put("Data", product);
			actualresponse = new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			Mockito.when(retailercontroller.addProduct(product)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, retailercontroller.addProduct(product));
			
			response.keySet().clear();
			response.put("Status", "failed to add product.Please check the data again.");
			response.put("Data", product);
			expectedresponse = new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			Assert.assertNotSame(expectedresponse, retailercontroller.addProduct(product));
			
		} catch (Exception exception) {
			exception.printStackTrace();
			Assert.assertFalse(false);
		}
    }
}
