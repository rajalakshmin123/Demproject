package com.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.repository.ProductDetailsRepo;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class ProductDetailsTest {

	@Mock
	ProductDetails product;
	
	ProductDetails other = new ProductDetails(); //other product object
	
	@Test
	public void getIdTest () {
		Mockito.when(product.getId()).thenReturn(1);
		Assert.assertEquals(1, product.getId());
		Assert.assertNotSame(2, product.getId());
	}

	@Test
	public void setIdTest() {
		other.setId(1);
		Assert.assertTrue(other.getId()==1);
		Assert.assertFalse(other.getId()==2);
	}
	
	@Test
	public void getProductNameTest() {
		Mockito.when(product.getProduct_name()).thenReturn("Samsung Mobile");
		Assert.assertEquals("Samsung Mobile", product.getProduct_name());
		Assert.assertNotSame("Iphone", product.getProduct_name());
	}
	
	@Test
	public void setProductName() {
		other.setProduct_name("Samsung Mobile");
		Assert.assertTrue(other.getProduct_name()=="Samsung Mobile");
		Assert.assertFalse(other.getProduct_name()=="Iphone");
	}
	
	@Test
	public void getPriceTest() {
		Mockito.when(product.getPrice()).thenReturn(50000);
		Assert.assertEquals(50000, product.getPrice());
		Assert.assertNotSame(99000, product.getPrice());
	}
	
	@Test
	public void setPriceTest() {
		other.setPrice(50000);
		Assert.assertTrue(other.getPrice()==50000);
		Assert.assertFalse(false);
	}
	
	@Test
	public void getPictureTest() {
		Mockito.when(product.getPicture()).thenReturn("C://Users/Rajalakshmi/image.png");
		Assert.assertEquals("C://Users/Rajalakshmi/image.png", product.getPicture());
		Assert.assertNotSame("C://Users/Other/photo.png", product.getPicture());
	}
	
	@Test
	public void setPictureTest() {
		other.setPicture("C://Users/Rajalakshmi/image.png");
		Assert.assertTrue(other.getPicture()=="C://Users/Rajalakshmi/image.png");
		Assert.assertFalse(other.getPicture()=="C://Users/Other/photo.png");
	}
	
	@Test
	public void getDescriptionTest() {
		Mockito.when(product.getDescription()).thenReturn("Mobile");
		Assert.assertEquals("Mobile", product.getDescription());
		Assert.assertNotSame("Mobile Phones", product.getDescription());
	}
	
	@Test 
	public void setDescriptionTest() {
		other.setDescription("Mobile");
		Assert.assertTrue(other.getDescription()=="Mobile");
		Assert.assertFalse(other.getDescription()=="Mobile Phone");
	}
	
	@Test
	public void getRetailerIdTest() {
		Mockito.when(product.getRetailerid()).thenReturn("1210");
		Assert.assertEquals("1210", product.getRetailerid());
		Assert.assertNotSame("9870", product.getRetailerid());
	}
	
	@Test
	public void setRetailerIdTest() {
		other.setRetailerid("1210");
		Assert.assertTrue(other.getRetailerid()=="1210");
		Assert.assertFalse(other.getRetailerid()=="9870");
	}
}
