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

import com.demo.model.ProductDetails;
import com.demo.repository.ProductDetailsRepo;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class ProductServiceTest {

	@Mock
	ProductDetailsRepo productsrepo;
	
	List<ProductDetails> actualresult = new ArrayList<>();
	List<ProductDetails> expectedresult = new ArrayList<>();
	ProductDetails actualproduct = new ProductDetails();  //other product objects
	ProductDetails expectedproduct = new ProductDetails();
	
	@Test
	public void findByKeywordTest() {
		//intialising product details object
		expectedproduct.setId(1);
		expectedproduct.setProduct_name("Samsung");
		expectedproduct.setPrice(50000);
		expectedproduct.setPicture("C://Users/Rajalakshmi/image.png");
		expectedproduct.setDescription("Mobile Phone");
		expectedproduct.setRetailerid("1210");
		
		actualresult.add(expectedproduct);
		expectedresult.add(expectedproduct);
		
		Mockito.when(productsrepo.findByKeyword("s")).thenReturn(actualresult);
		Assert.assertTrue(expectedresult.toString().equals(productsrepo.findByKeyword("s").toString()));
		
		actualproduct.setId(2);
		actualproduct.setProduct_name("Iphone");
		actualproduct.setPrice(97000);
		actualproduct.setPicture("C://Users/Rajalakshmi/photo.png");
		actualproduct.setDescription("Mobile Phone");
		actualproduct.setRetailerid("1211");
		
		actualresult.add(actualproduct);
		Mockito.when(productsrepo.findByKeyword("s")).thenReturn(actualresult);
		Assert.assertFalse(expectedresult.toString().equals(productsrepo.findByKeyword("s").toString()));
	}

	@Test
	public void saveProductsTest() {
		expectedproduct.setId(1);
		expectedproduct.setProduct_name("Samsung");
		expectedproduct.setPrice(50000);
		expectedproduct.setPicture("C://Users/Rajalakshmi/image.png");
		expectedproduct.setDescription("Mobile Phone");
		expectedproduct.setRetailerid("1210");
		
		productsrepo.save(expectedproduct);
		Assert.assertEquals(1, expectedproduct.getId());
		Assert.assertNotEquals(2, expectedproduct.getId());
		
		Assert.assertEquals("Samsung", expectedproduct.getProduct_name());
		Assert.assertNotEquals("Redmi", expectedproduct.getProduct_name());
		
		Assert.assertEquals(50000, expectedproduct.getPrice());
		Assert.assertNotEquals(96000, expectedproduct.getPrice());
		
		Assert.assertEquals("C://Users/Rajalakshmi/image.png", expectedproduct.getPicture());
		Assert.assertNotEquals("C://Users/random/photo.png", expectedproduct.getPicture());
		
		Assert.assertEquals("Mobile Phone", expectedproduct.getDescription());
		Assert.assertNotEquals("Redmi Mobiles", expectedproduct.getDescription());
		
		Assert.assertEquals("1210", expectedproduct.getRetailerid());
		Assert.assertNotEquals("9870", expectedproduct.getRetailerid());
	}
}
