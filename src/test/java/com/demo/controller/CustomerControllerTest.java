package com.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.model.CustomerDetails;
import com.demo.model.ProductDetails;
import com.demo.service.AuthenticationService;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class CustomerControllerTest {
	
	@Mock
	CustomerDetails customer;
	
	@Mock 
	ProductDetails product;
	
	@Mock
	AuthenticationService authservice;
		
	JSONObject response = new JSONObject();
	
	@Mock
	CustomerController customercontroller;
		
	ResponseEntity<JSONObject> expectedresponse = null; 
	ResponseEntity<JSONObject> actualresponse =null;

	@Test  
    public void registerUser(){  
		try {
			//initialsing expected response
			response.put("response","Internal errors");
			
			expectedresponse=new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			Mockito.when(customercontroller.registerUser(customer)).thenReturn(expectedresponse);
			Assert.assertEquals(expectedresponse, customercontroller.registerUser(customer));

			response.keySet().clear();
			response.put("response", "User registered Successfully");
			response.put("Data", customer);
			actualresponse=new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			Mockito.when(customercontroller.registerUser(customer)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, customercontroller.registerUser(customer));
			
			response.keySet().clear();
			response.put("response", "User already exists.");
			response.put("Data", customer);
			actualresponse=new ResponseEntity<JSONObject>(response, HttpStatus.CONFLICT);
			Mockito.when(customercontroller.registerUser(customer)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, customercontroller.registerUser(customer));

		} catch (Exception exception) {
			exception.printStackTrace();
			Assert.assertFalse(false);
		}
    }  

	@Test  
    public void loginUser(){  
		try {
			
			response.put("response","Internal errors");
			expectedresponse=new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
						
			Mockito.when(customercontroller.loginUser(customer)).thenReturn(expectedresponse);
			Assert.assertEquals(expectedresponse, customercontroller.loginUser(customer));

			response.keySet().clear();
			response.put("Status", "success");
			response.put("Data", customer);
			actualresponse=new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			Mockito.when(customercontroller.loginUser(customer)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, customercontroller.loginUser(customer));
			
			response.keySet().clear();
			response.put("Status", "failed");
			response.put("Data", customer);
			actualresponse=new ResponseEntity<JSONObject>(response, HttpStatus.UNAUTHORIZED);
			Mockito.when(customercontroller.loginUser(customer)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, customercontroller.loginUser(customer));

		} catch (Exception exception) {
			exception.printStackTrace();
			Assert.assertFalse(false);
		}
    }  
	
	@Test  
    public void logOutUser(){  
		try {
			response.put("response","Internal errors");
			expectedresponse=new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			Mockito.when(customercontroller.logOutUser(customer)).thenReturn(expectedresponse);
			Assert.assertEquals(expectedresponse, customercontroller.logOutUser(customer));

			response.keySet().clear();
			response.put("Status", "success");
			response.put("Data", customer);
			actualresponse=new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			Mockito.when(customercontroller.logOutUser(customer)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, customercontroller.logOutUser(customer));

			response.keySet().clear();
			response.put("Status", "failed");
			response.put("Data", customer);
			actualresponse=new ResponseEntity<JSONObject>(response, HttpStatus.UNAUTHORIZED);
			Mockito.when(customercontroller.logOutUser(customer)).thenReturn(actualresponse);
			Assert.assertNotSame(expectedresponse, customercontroller.logOutUser(customer));

		} catch (Exception exception) {
			exception.printStackTrace();
			Assert.assertFalse(false);
		}
    }  
	
	@Test  
    public void findAllCustomer(){  
		try {
			List<CustomerDetails> result = new ArrayList<>();
			ResponseEntity<List<CustomerDetails>> expectedValue = null; 
			ResponseEntity<List<CustomerDetails>> actualValue=null;
			Mockito.when(customercontroller.findAllCustomer()).thenReturn(actualValue);
			Assert.assertEquals(expectedValue, customercontroller.findAllCustomer());

			customer.setId(1);
			customer.setCustomerid("1210");
			customer.setEmail("nrajalakshmi9745@gmail.com");
			customer.setName("Rajalakshmi");
			customer.setPassword("12345");
			customer.setPhone("9539930594");
			customer.setStatus("active");
			
			result.add(customer);
			actualValue = new ResponseEntity<List<CustomerDetails>>(result, HttpStatus.OK);
			Mockito.when(customercontroller.findAllCustomer()).thenReturn(actualValue);
			Assert.assertNotSame(expectedValue, customercontroller.findAllCustomer());
			
			expectedValue = new ResponseEntity<List<CustomerDetails>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
			Assert.assertNotSame(expectedValue, customercontroller.findAllCustomer());
		} catch (Exception exception) {
			exception.printStackTrace();
			Assert.assertFalse(false);
		}
    }  
	
	@Test  
    public void searchProductByname(){  
		try {
			List<ProductDetails> result = new ArrayList<>();

			ResponseEntity<List<ProductDetails>> expectedValue = null; 
			ResponseEntity<List<ProductDetails>> actualValue=null;
			Mockito.when(customercontroller.searchProductByname( "s")).thenReturn(actualValue);
			Assert.assertEquals(expectedValue, customercontroller.searchProductByname( "s"));

			product.setId(1);
			product.setProduct_name("Samsung");
			product.setPrice(50000);
			product.setPicture("C://Users/Rajalakshmi/image.png");
			product.setDescription("Mobile Phone");
			product.setRetailerid("1210");
			
			result.add(product);
			actualValue = new ResponseEntity<List<ProductDetails>>(result, HttpStatus.OK);
			Mockito.when(customercontroller.searchProductByname( "s")).thenReturn(actualValue);
			Assert.assertNotSame(expectedValue, customercontroller.searchProductByname( "s"));
			
			expectedValue = new ResponseEntity<List<ProductDetails>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
			Assert.assertNotSame(expectedValue, customercontroller.searchProductByname( "s"));
			
		} catch (Exception exception) {
			exception.printStackTrace();
			Assert.assertFalse(false);
		}
    } 
}
