package com.initech.customer.util;

import static com.inittech.customer.common.CustomerConstant.PHONE_NUMBER_VALUE_EMPTY_NULL;
import static com.inittech.customer.common.CustomerConstant.PHONE_NUMBER_VALUE_INVALID;
import static com.inittech.customer.common.CustomerConstant.PHONE_NUMBER_VALUE_INVALID_FORMAT;
import static com.inittech.customer.common.CustomerConstant.PHONE_NUMBER_REGX_FORMAT;
import static com.inittech.customer.common.CustomerConstant.getKey;

import java.util.regex.Pattern;
/**
 * This Class Mainly used to Validate Phone number  and return appropriate response.
 * @author anbus
 *
 */
public class PhoneNumberValidationUtil {

	public static String phoneNumberValidation(String phoneNumber) {

		
		if (phoneNumber == null || phoneNumber.isEmpty()) {
			return getKey(PHONE_NUMBER_VALUE_EMPTY_NULL);
		}
		if (!(phoneNumber.length() >= 10 )) {
			return getKey(PHONE_NUMBER_VALUE_INVALID_FORMAT);
		}

		return phoneNumberFormatValidation(phoneNumber);
		
		
	}

	private static String phoneNumberFormatValidation(String phoneNumber) {
		Pattern mobilePhoneNumberPatternHU = Pattern.compile(PHONE_NUMBER_REGX_FORMAT);
		return mobilePhoneNumberPatternHU.matcher(phoneNumber).find() ? "Success":"Failure";

	}

	
}
