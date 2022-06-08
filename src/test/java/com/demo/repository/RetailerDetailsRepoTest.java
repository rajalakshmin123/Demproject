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

import com.demo.model.RetailerDetails;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class RetailerDetailsRepoTest {

	@Mock
	RetailerDetailsRepo retailerrepo;

	List<RetailerDetails> retailer_actualresult = new ArrayList<>();
	List<RetailerDetails> retailer_expectedresult = new ArrayList<>();
	RetailerDetails actualretailer = new RetailerDetails();
	RetailerDetails expectedretailer = new RetailerDetails();
	
	@Test
	public void findAllTest() {
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
		Assert.assertEquals(retailer_expectedresult.toString(), retailerrepo.findAll().toString());
		
		actualretailer.setId(2);
		actualretailer.setRetailerid("1567");
		actualretailer.setEmail("nrajalakshmi@gmail.com");
		actualretailer.setName("Rajalakshmi");
		actualretailer.setPassword("9870");
		actualretailer.setPhone("9087654321");
		actualretailer.setStatus("inactive");
		retailer_expectedresult.add(actualretailer);
		Assert.assertNotSame(retailer_expectedresult.toString(), retailerrepo.findAll().toString());
	}
	
	@Test
	public void findUsersByemailTest() {
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
