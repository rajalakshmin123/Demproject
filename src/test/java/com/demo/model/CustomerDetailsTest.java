package com.demo.model;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class CustomerDetailsTest {

	@Mock
	CustomerDetails customer;
	
	CustomerDetails other= new CustomerDetails(); //other customer object
	
	@Test
	public void getStatusTest() {
		Mockito.when(customer.getStatus()).thenReturn("active");
		Assert.assertEquals("active", customer.getStatus());
		Assert.assertNotSame("inactive", customer.getStatus());
		
		Mockito.when(customer.getStatus()).thenReturn("inactive");
		Assert.assertEquals("inactive", customer.getStatus());
		Assert.assertNotSame("active", customer.getStatus());
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
	
	@Test
	public void getCustomeridTest() {
		Mockito.when(customer.getCustomerid()).thenReturn("1210");
		Assert.assertEquals("1210", customer.getCustomerid());
		Assert.assertNotSame("2345", customer.getCustomerid());
	}
	
	@Test
	public void setCustomeridTest() {
		other.setCustomerid("1210");
		Assert.assertTrue(other.getCustomerid()=="1210");
		Assert.assertFalse(other.getCustomerid()=="2340");
	}
	
	@Test
	public void getIdTest() {
		Mockito.when(customer.getId()).thenReturn(1);
		Assert.assertEquals(1, customer.getId());
		Assert.assertNotSame(2, customer.getId());
	}
	
	@Test
	public void setIdTest() {
		other.setId(1);
		Assert.assertTrue(other.getId()==1);
		Assert.assertFalse(other.getId()==2);
	}
	
	@Test
	public void getNameTest() {
		Mockito.when(customer.getName()).thenReturn("rajalakshmi");
		Assert.assertEquals("rajalakshmi", customer.getName());
		Assert.assertNotSame("Amrutha", customer.getName());
	}
	
	@Test
	public void setNameTest() {
		other.setName("Rajalakshmi");
		Assert.assertTrue(other.getName()=="Rajalakshmi");
		Assert.assertFalse(other.getName()=="Amrutha");
	}
	
	@Test
	public void getEmailTest() {
		Mockito.when(customer.getEmail()).thenReturn("rajalakshmin@gmail.com");
		Assert.assertEquals("rajalakshmin@gmail.com", customer.getEmail());
		Assert.assertNotSame("rajalakshmi.n11@gmail.com", customer.getEmail());
	}
	
	@Test
	public void setEmailTest() {
		other.setEmail("rajalakshmin@gmail.com");
		Assert.assertTrue(other.getEmail()=="rajalakshmin@gmail.com");
		Assert.assertFalse(other.getEmail()=="rajalakshmi.n11@gmail.com");
	}
	
	@Test
	public void getPhoneTest() {
		Mockito.when(customer.getPhone()).thenReturn("9123456780");
		Assert.assertEquals("9123456780", customer.getPhone());
		Assert.assertNotSame("9539930594", customer.getPhone());
	}
	
	@Test
	public void setPhoneTest() {
		other.setPhone("9123456780");
		Assert.assertTrue(other.getPhone()=="9123456780");
		Assert.assertFalse(other.getPhone()=="9539930594");
	}
	
	@Test
	public void getPasswordTest() {
		Mockito.when(customer.getPassword()).thenReturn("12345");
		Assert.assertEquals("12345", customer.getPassword());
		Assert.assertNotSame("098765", customer.getPassword());
	}
	
	@Test
	public void setPasswordTest() {
		other.setPassword("12345");
		Assert.assertTrue(other.getPassword()=="12345");
		Assert.assertFalse(other.getPassword()=="098765");
	}
}
