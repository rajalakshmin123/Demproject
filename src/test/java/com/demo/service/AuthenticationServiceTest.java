package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.model.CustomerDetails;
import com.demo.model.RetailerDetails;
import com.demo.repository.CustomerDetailsRepo;
import com.demo.repository.RetailerDetailsRepo;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class AuthenticationServiceTest {
	
	@Mock
	CustomerDetailsRepo customerrepo;
	
	@Mock
	RetailerDetailsRepo retailerrepo;
	
	List<CustomerDetails> actualresult = new ArrayList<>();
	List<CustomerDetails> expectedresult = new ArrayList<>();
	CustomerDetails actualcustomer = new CustomerDetails();  
	CustomerDetails expectedcustomer = new CustomerDetails();
	
	List<RetailerDetails> retailer_actualresult = new ArrayList<>();
	List<RetailerDetails> retailer_expectedresult = new ArrayList<>();
	RetailerDetails actualretailer = new RetailerDetails();
	RetailerDetails expectedretailer = new RetailerDetails();
	
	@Test
	public void findAllCustomerTest() {
		expectedcustomer.setId(1);
		expectedcustomer.setCustomerid("1210");
		expectedcustomer.setEmail("nrajalakshmi9745@gmail.com");
		expectedcustomer.setName("Rajalakshmi");
		expectedcustomer.setPassword("12345");
		expectedcustomer.setPhone("9539930594");
		expectedcustomer.setStatus("active");
		
		actualresult.add(expectedcustomer);
		expectedresult.add(expectedcustomer);
		Mockito.when(customerrepo.findAll()).thenReturn(actualresult);
		Assert.assertTrue(expectedresult.toString().equals(actualresult.toString())); 

		actualcustomer.setId(2);
		actualcustomer.setCustomerid("1567");
		actualcustomer.setEmail("nrajalakshmi@gmail.com");
		actualcustomer.setName("Rajalakshmi");
		actualcustomer.setPassword("9870");
		actualcustomer.setPhone("9087654321");
		actualcustomer.setStatus("inactive");
		actualresult.add(actualcustomer);
		Assert.assertFalse(expectedresult.toString().equals(actualresult.toString()));
	}
	
	@Test
	public void saveCustomerTest() {
		expectedcustomer.setId(1);
		expectedcustomer.setCustomerid("1210");
		expectedcustomer.setEmail("nrajalakshmi9745@gmail.com");
		expectedcustomer.setName("Rajalakshmi");
		expectedcustomer.setPassword("12345");
		expectedcustomer.setPhone("9539930594");
		expectedcustomer.setStatus("active");
		
		customerrepo.save(expectedcustomer);
		
		Assert.assertEquals(1, expectedcustomer.getId());
		Assert.assertNotSame(2, expectedcustomer.getId());
		
		Assert.assertEquals("1210", expectedcustomer.getCustomerid());
		Assert.assertNotSame("2234", expectedcustomer.getCustomerid());
		
		Assert.assertEquals("nrajalakshmi9745@gmail.com", expectedcustomer.getEmail());
		Assert.assertNotSame("ameya@gmail.com", expectedcustomer.getEmail());
		
		Assert.assertEquals("Rajalakshmi", expectedcustomer.getName());
		Assert.assertNotSame("Ameya", expectedcustomer.getName());
		
		Assert.assertEquals("12345", expectedcustomer.getPassword());
		Assert.assertNotSame("223467", expectedcustomer.getPassword());
		
		Assert.assertEquals("9539930594", expectedcustomer.getPhone());
		Assert.assertNotSame("9087654321", expectedcustomer.getPhone());
		
		Assert.assertEquals("active", expectedcustomer.getStatus());
		Assert.assertNotSame("inactive", expectedcustomer.getStatus());
	}
	
	@Test
	public void findUsersByemailTest(){
		expectedcustomer.setId(1);
		expectedcustomer.setCustomerid("1210");
		expectedcustomer.setEmail("nrajalakshmi9745@gmail.com");
		expectedcustomer.setName("Rajalakshmi");
		expectedcustomer.setPassword("12345");
		expectedcustomer.setPhone("9539930594");
		expectedcustomer.setStatus("active");
		
		actualcustomer.setId(1);
		actualcustomer.setCustomerid("1210");
		actualcustomer.setEmail("nrajalakshmi9745@gmail.com");
		actualcustomer.setName("Rajalakshmi");
		actualcustomer.setPassword("12345");
		actualcustomer.setPhone("9539930594");
		actualcustomer.setStatus("active");
		
		String email="nrajalakshmi9745@gmail.com";
		Mockito.when(customerrepo.findUsersByemail(email))
			.thenReturn(actualcustomer);
		Assert.assertEquals(expectedcustomer.toString(), customerrepo.findUsersByemail(email).toString());
		
		expectedcustomer.setId(2);
		Assert.assertNotSame(expectedcustomer.toString(), customerrepo.findUsersByemail(email).toString());
	}
	
	@Test
	public void findAllRetailerTest() {
		expectedretailer.setId(1);
		expectedretailer.setRetailerid("1210");
		expectedretailer.setEmail("nrajalakshmi9745@gmail.com");
		expectedretailer.setName("Rajalakshmi");
		expectedretailer.setPassword("12345");
		expectedretailer.setPhone("9539930594");
		expectedretailer.setStatus("active");
		
		retailer_actualresult.add(expectedretailer);
		retailer_expectedresult.add(expectedretailer);
		
		Mockito.when(retailerrepo.findAll()).thenReturn(retailer_actualresult);
		Assert.assertTrue(retailer_expectedresult.toString().equals(retailerrepo.findAll().toString())); 

		actualretailer.setId(2);
		actualretailer.setRetailerid("1567");
		actualretailer.setEmail("nrajalakshmi@gmail.com");
		actualretailer.setName("Rajalakshmi");
		actualretailer.setPassword("9870");
		actualretailer.setPhone("9087654321");
		actualretailer.setStatus("inactive");
		
		retailer_actualresult.add(actualretailer);
		
		Mockito.when(retailerrepo.findAll()).thenReturn(retailer_actualresult);
		Assert.assertFalse(retailer_expectedresult.toString().equals(retailerrepo.findAll().toString()));
	}
	
	@Test
	public void saveRetailer() {
		actualretailer.setId(1);
		actualretailer.setRetailerid("1210");
		actualretailer.setEmail("nrajalakshmi9745@gmail.com");
		actualretailer.setName("Rajalakshmi");
		actualretailer.setPassword("12345");
		actualretailer.setPhone("9539930594");
		actualretailer.setStatus("active");
		
		retailerrepo.save(actualretailer);
		
		Assert.assertEquals(1, actualretailer.getId());
		Assert.assertNotSame(2, actualretailer.getId());
		
		Assert.assertEquals("1210", actualretailer.getRetailerid());
		Assert.assertNotSame("2234", actualretailer.getRetailerid());
		
		Assert.assertEquals("nrajalakshmi9745@gmail.com", actualretailer.getEmail());
		Assert.assertNotSame("ameya@gmail.com", actualretailer.getEmail());
		
		Assert.assertEquals("Rajalakshmi", actualretailer.getName());
		Assert.assertNotSame("Ameya", actualretailer.getName());
		
		Assert.assertEquals("12345", actualretailer.getPassword());
		Assert.assertNotSame("223467", actualretailer.getPassword());
		
		Assert.assertEquals("9539930594", actualretailer.getPhone());
		Assert.assertNotSame("9087654321", actualretailer.getPhone());
		
		Assert.assertEquals("active", actualretailer.getStatus());
		Assert.assertNotSame("inactive", actualretailer.getStatus());
	}
	
	@Test
	public void findRetailersByemailTest() {
		expectedretailer.setId(1);
		expectedretailer.setRetailerid("1210");
		expectedretailer.setEmail("nrajalakshmi9745@gmail.com");
		expectedretailer.setName("Rajalakshmi");
		expectedretailer.setPassword("12345");
		expectedretailer.setPhone("9539930594");
		expectedretailer.setStatus("active");
		
		actualretailer.setId(1);
		actualretailer.setRetailerid("1210");
		actualretailer.setEmail("nrajalakshmi9745@gmail.com");
		actualretailer.setName("Rajalakshmi");
		actualretailer.setPassword("12345");
		actualretailer.setPhone("9539930594");
		actualretailer.setStatus("active");
		
		String email="nrajalakshmi9745@gmail.com";
		Mockito.when(retailerrepo.findRetailersByemail(email))
			.thenReturn(actualretailer);
		Assert.assertEquals(expectedretailer.toString(), retailerrepo.findRetailersByemail(email).toString());
		
		expectedretailer.setId(2);
		Assert.assertNotSame(expectedretailer.toString(), retailerrepo.findRetailersByemail(email).toString());
	
	}
}
