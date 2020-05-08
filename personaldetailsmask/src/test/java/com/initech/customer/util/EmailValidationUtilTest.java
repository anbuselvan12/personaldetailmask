package com.initech.customer.util;

import org.junit.Test;

import junit.framework.Assert;

public class EmailValidationUtilTest {
	
	public static String EMAIL ="anbuselvan.angamuthu@gmail.com";

		@Test
	    public void testEmailMaskWithNull() {
	     String result = EmailValidationUtil.emailValidation(null); 
		 Assert.assertEquals("Email value is not exist", result);
	
	    }
		
		@Test
	    public void testEmailMaskWithEmpty() {
	     String result = EmailValidationUtil.emailValidation(""); 
		 Assert.assertEquals("Email value is not exist", result);
	
	    }

		@Test
	    public void testEmailMaskWithMoreThanEightyCharLength() {
	     String result = EmailValidationUtil.emailValidation("anbuselvananbuselvananbuselvananbuselvan.angamuthuangamuthuangamuthu121@gmail.com"); 
		 Assert.assertEquals("Email length should not exceed more than 80 characters", result);
	
	    }
		
	
		
}
