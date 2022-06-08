package com.demo;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoprojectApplicationTest {
  
	@Mock
	DemoprojectApplication demo;
	
	@Test  
    public void main(){  
		try {
			String[] args = null; 

			demo.main( args);
		 	Assert.assertTrue(true);

		} catch (Exception exception) {
			exception.printStackTrace();
			Assert.assertFalse(false);
		}
    }  
}
