package com.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class RetailerDetailsTest {

	@Mock
	RetailerDetails retailer;
	
	RetailerDetails other= new RetailerDetails(); //other retailer object
	
	@Test
	public void getIdTest() {
		Mockito.when(retailer.getId()).thenReturn(1);
		Assert.assertEquals(1, retailer.getId());
		Assert.assertNotSame(2, retailer.getId());
	}
	
	@Test
	public void setIdTest() {
		other.setId(1);
		Assert.assertTrue(other.getId()==1);
		Assert.assertFalse(other.getId()==2);
	}
	
	@Test
	public void getNameTest() {
		Mockito.when(retailer.getName()).thenReturn("rajalakshmi");
		Assert.assertEquals("rajalakshmi", retailer.getName());
		Assert.assertNotSame("Amrutha", retailer.getName());
	}
	
	@Test
	public void setNameTest() {
		other.setName("Rajalakshmi");
		Assert.assertTrue(other.getName()=="Rajalakshmi");
		Assert.assertFalse(other.getName()=="Amrutha");
	}
	
	@Test
	public void getEmailTest() {
		Mockito.when(retailer.getEmail()).thenReturn("rajalakshmin@gmail.com");
		Assert.assertEquals("rajalakshmin@gmail.com", retailer.getEmail());
		Assert.assertNotSame("rajalakshmi.n11@gmail.com", retailer.getEmail());
	}
	
	@Test
	public void setEmailTest() {
		other.setEmail("rajalakshmin@gmail.com");
		Assert.assertTrue(other.getEmail()=="rajalakshmin@gmail.com");
		Assert.assertFalse(other.getEmail()=="rajalakshmi.n11@gmail.com");
	}
	
	@Test
	public void getPhoneTest() {
		Mockito.when(retailer.getPhone()).thenReturn("9123456780");
		Assert.assertEquals("9123456780", retailer.getPhone());
		Assert.assertNotSame("9539930594", retailer.getPhone());
	}

	@Test
	public void setPhoneTest() {
		other.setPhone("9123456780");
		Assert.assertTrue(other.getPhone()=="9123456780");
		Assert.assertFalse(other.getPhone()=="9539930594");
	}
	
	@Test
	public void getPasswordTest() {
		Mockito.when(retailer.getPassword()).thenReturn("12345");
		Assert.assertEquals("12345", retailer.getPassword());
		Assert.assertNotSame("098765", retailer.getPassword());
	}
	
	@Test
	public void setPasswordTest() {
		other.setPassword("12345");
		Assert.assertTrue(other.getPassword()=="12345");
		Assert.assertFalse(other.getPassword()=="098765");
	}

	@Test
	public void getRetaileridTest() {
		Mockito.when(retailer.getRetailerid()).thenReturn("1210");
		Assert.assertEquals("1210", retailer.getRetailerid());
		Assert.assertNotSame("2345", retailer.getRetailerid());
	}
	
	@Test
	public void setRetaileridTest() {
		other.setRetailerid("1210");
		Assert.assertTrue(other.getRetailerid()=="1210");
		Assert.assertFalse(other.getRetailerid()=="2340");
	}

	@Test
	public void getStatusTest() {
		Mockito.when(retailer.getStatus()).thenReturn("active");
		Assert.assertEquals("active", retailer.getStatus());
		Assert.assertNotSame("inactive", retailer.getStatus());
		
		Mockito.when(retailer.getStatus()).thenReturn("inactive");
		Assert.assertEquals("inactive", retailer.getStatus());
		Assert.assertNotSame("active", retailer.getStatus());
	}

	@Test
	public void setStatusTest() {
		other.setStatus("active");
		Assert.assertTrue(other.getStatus()=="active");
		Assert.assertFalse(other.getStatus()=="inactive");
		
		other.setStatus("inactive");
		Assert.assertTrue(other.getStatus()=="inactive");
		Assert.assertFalse(other.getStatus()=="active");		
	}
}
