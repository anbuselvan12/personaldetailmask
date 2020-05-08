package com.initech.customer.util;

import org.junit.Test;

import junit.framework.Assert;

public class PhoneNumberValidatioUtilTest {
	
	
	@Test
    public void testPhoneNumberMaskWithNull() {
     String result = PhoneNumberValidationUtil.phoneNumberValidation(null); 
	 Assert.assertEquals("Customer Phone Number value is not exist", result);

    }
	
	@Test
    public void testPhoneNumberMaskWithEmpty() {
     String result = PhoneNumberValidationUtil.phoneNumberValidation(""); 
	 Assert.assertEquals("Customer Phone Number value is not exist", result);

    }
	
	@Test
    public void testPhoneNumberMaskWithLessThan10Character() {
     String result = PhoneNumberValidationUtil.phoneNumberValidation("704780950"); 
	 Assert.assertEquals("Customer Phone Number is invalid format", result);

    }
	
	@Test
    public void testPhoneNumberMaskWithMoreThan16Character() {
     String result = PhoneNumberValidationUtil.phoneNumberValidation("++1-(704)-780-9509"); 
	 Assert.assertEquals("Failure", result);

    }


	@Test
    public void testPhoneNumberWithInvalidNumber() {
     String result = PhoneNumberValidationUtil.phoneNumberValidation("WWWWWWWWWWWW"); 
	 Assert.assertEquals("Failure", result);

    }

}
