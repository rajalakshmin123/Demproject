package com.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

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

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class ProductDetailsRepoTest {

	@Mock
	ProductDetailsRepo productsrepo;
	
	List<ProductDetails> actualresult = new ArrayList<>();
	List<ProductDetails> expectedresult = new ArrayList<>();
	ProductDetails actualproduct = new ProductDetails();  //other product objects
	ProductDetails expectedproduct = new ProductDetails();

	@Test
	public void findByKeywordTest() {
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
		
		expectedresult.add(actualproduct);
		Assert.assertFalse(expectedresult.toString().equals(productsrepo.findByKeyword("s").toString()));
	}
	
	@Test
	public void findByIdTest() {
		expectedproduct.setId(1);
		expectedproduct.setProduct_name("Samsung");
		expectedproduct.setPrice(50000);
		expectedproduct.setPicture("C://Users/Rajalakshmi/image.png");
		expectedproduct.setDescription("Mobile Phone");
		expectedproduct.setRetailerid("1210");
		
		actualproduct.setId(1);
		actualproduct.setProduct_name("Samsung");
		actualproduct.setPrice(50000);
		actualproduct.setPicture("C://Users/Rajalakshmi/image.png");
		actualproduct.setDescription("Mobile Phone");
		actualproduct.setRetailerid("1210");
		
		Mockito.when(productsrepo.findById(1)).thenReturn(actualproduct);
		Assert.assertEquals(expectedproduct.toString(),productsrepo.findById(1).toString());
		
		expectedproduct.setId(2);
		Assert.assertNotSame(expectedproduct.toString(),productsrepo.findById(1).toString());
	}
}
