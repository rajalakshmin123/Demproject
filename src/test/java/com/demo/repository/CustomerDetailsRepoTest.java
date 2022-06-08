package com.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.model.CustomerDetails;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class CustomerDetailsRepoTest {

	@Mock
	CustomerDetailsRepo customerrepo;
	
	List<CustomerDetails> actualresult = new ArrayList<>();
	List<CustomerDetails> expectedresult = new ArrayList<>();
	CustomerDetails actualcustomer = new CustomerDetails();  
	CustomerDetails expectedcustomer = new CustomerDetails();

	@Test
	public void findAllTest() {
		expectedcustomer.setId(1);
		expectedcustomer.setCustomerid("1210");
		expectedcustomer.setEmail("nrajalakshmi9745@gmail.com");
		expectedcustomer.setName("Rajalakshmi");
		expectedcustomer.setPassword("12345");
		expectedcustomer.setPhone("9539930594");
		expectedcustomer.setStatus("active");
		
		actualcustomer.setId(2);
		actualcustomer.setCustomerid("1567");
		actualcustomer.setEmail("nrajalakshmi@gmail.com");
		actualcustomer.setName("Rajalakshmi");
		actualcustomer.setPassword("9870");
		actualcustomer.setPhone("9087654321");
		actualcustomer.setStatus("inactive");
		
		actualresult.add(expectedcustomer);
		expectedresult.add(expectedcustomer);
		
		Mockito.when(customerrepo.findAll()).thenReturn(actualresult);
		Assert.assertEquals(expectedresult.toString(), customerrepo.findAll().toString());
		
		expectedresult.add(actualcustomer);
		Assert.assertNotSame(expectedresult.toString(), customerrepo.findAll().toString());
	}
	
	@Test
	public void findUsersByemailTest() {
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
}
