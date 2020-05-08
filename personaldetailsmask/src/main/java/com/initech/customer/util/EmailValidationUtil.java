package com.initech.customer.util;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.inittech.customer.common.CustomerConstant.EMAIL_LENGTH;
import static com.inittech.customer.common.CustomerConstant.EMAIL_VALUE_INVALID;
import static com.inittech.customer.common.CustomerConstant.EMAIL_VALUE_EMPTY_NULL;
import static com.inittech.customer.common.CustomerConstant.EMAIL_VALUE_LENGTH_INVALID;
import static com.inittech.customer.common.CustomerConstant.EMAIL_REGX_FORMAT;
import static com.inittech.customer.common.CustomerConstant.SUCCESS;
import static com.inittech.customer.common.CustomerConstant.getKey;

public class EmailValidationUtil {
	
	public static String emailValidation(String email) {
		
		if(!Optional.ofNullable(email).isPresent() || email.trim().isEmpty()) {
			 return getKey(EMAIL_VALUE_EMPTY_NULL);
		}
		
		if(!(email.length() < EMAIL_LENGTH)) {
			 return getKey(EMAIL_VALUE_LENGTH_INVALID);
		}
	    
		if(validateEmailAddress(email)) {
	    	 return SUCCESS;
		 }else{
			 return getKey(EMAIL_VALUE_INVALID);
		}
		
		
		
	}


	private static boolean validateEmailAddress(String email) {
		Pattern r = Pattern.compile(EMAIL_REGX_FORMAT);
		Matcher m = r.matcher(email);
		return m.find();
	}

}
