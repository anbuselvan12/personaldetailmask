package com.initech.customer.util;

import org.junit.Test;

import junit.framework.Assert;

public class StringMaskUtilsTest {
	
	@Test
    public void testEmailMaskValidEmail() {
     String result = StringMaskUtils.emailAddressMask("anbuselvan.angamuthu@gmail.com"); 
	 Assert.assertEquals("a******************u@gmail.com", result);

    }
	
	
	@Test
    public void testEmailMaskValidDiffEmail() {
     String result = StringMaskUtils.emailAddressMask("selva_kum@gmail.com"); 
	 Assert.assertEquals("s*******m@gmail.com", result);

    }
	
	@Test
    public void testEmailMaskValidNoName() {
     String result = StringMaskUtils.emailAddressMask("@gmail.com"); 
	 Assert.assertEquals("Email value is valid", result);

    }
	
	@Test
    public void testEmailMaskOncCharacter() {
     String result = StringMaskUtils.emailAddressMask("a@gmail.com"); 
	 Assert.assertEquals("a@gmail.com", result);
   }
	@Test
    public void testEmailMaskInvalid() {
     String result = StringMaskUtils.emailAddressMask("agmail.com"); 
	 Assert.assertEquals("Email value is valid", result);
   }
	
	
	@Test
    public void testPhoneNumberMaskWithCountryCode() {
     String result = StringMaskUtils.phoneNumberMask("+1(704)-780-9509"); 
	 Assert.assertEquals("+1(704)-###-9509", result);

    }
	@Test
    public void testPhoneNumberMaskWithCountryCode1() {
     String result = StringMaskUtils.phoneNumberMask("+1-(704)-780-9509"); 
	 Assert.assertEquals("+1-(704)-###-9509", result);

    }
	
	@Test
    public void testPhoneNumberMaskWithCountryCodeNoPlusesign() {
     String result = StringMaskUtils.phoneNumberMask("1(704)-780-9509"); 
	 Assert.assertEquals("1(704)-###-9509", result);

    }
	
	@Test
    public void testPhoneNumberMaskWithOutCountryCode() {
     String result = StringMaskUtils.phoneNumberMask("(704)-780-9509"); 
	 Assert.assertEquals("(704)-###-9509", result);

    }
	
	@Test
    public void testPhoneNumberMaskWithOutCountryWithPlusSign() {
     String result = StringMaskUtils.phoneNumberMask("+(704)-780-9509"); 
	 Assert.assertEquals("+(704)-###-9509", result);

    }
	@Test
    public void testPhoneNumberMaskWithWithSpace() {
     String result = StringMaskUtils.phoneNumberMask("+(704)-780 9509"); 
	 Assert.assertEquals("+(704)-### 9509", result);

    }
	@Test
    public void testPhoneNumberMaskWithSpecialChar() {
     String result = StringMaskUtils.phoneNumberMask("+(704)78$9509"); 
	 Assert.assertEquals("Customer Given phone number is invalid", result);

    }
	@Test
    public void testPhoneNumberMaskWithPlainNumber() {
     String result = StringMaskUtils.phoneNumberMask("7047809509"); 
	 Assert.assertEquals("704###9509", result);

    }
	
	@Test
    public void testPhoneNumberMaskWithPlainNumberAndCountryCode() {
     String result = StringMaskUtils.phoneNumberMask("+17047809509"); 
	 Assert.assertEquals("+1704###9509", result);

    }
	
	@Test
    public void testPhoneNumberMaskWithPlainNumberAndCountryCodeWithOutPlusSign() {
     String result = StringMaskUtils.phoneNumberMask("17047809509"); 
	 Assert.assertEquals("1704###9509", result);

    }
	
	@Test
    public void testPhoneNumberWithCharacter() {
     String result = StringMaskUtils.phoneNumberMask("+1704-780-CODE"); 
	 Assert.assertEquals("+1704-###-CODE", result);

    }
	
	@Test
    public void testPhoneNumberWithInvalidNumber() {
     String result = StringMaskUtils.phoneNumberMask("WWWWWWWWWWWW"); 
	 Assert.assertEquals("Customer Given phone number is invalid", result);

    }
	

	@Test
    public void testPhoneNumberMaskWithEmpty() {
     String result = StringMaskUtils.phoneNumberMask(""); 
	 Assert.assertEquals("Customer Phone Number value is not exist", result);

    }
	@Test
    public void testPhoneNumberMaskWithNull() {
     String result = StringMaskUtils.phoneNumberMask(null); 
	 Assert.assertEquals("Customer Phone Number value is not exist", result);

    }

}
