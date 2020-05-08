package com.initech.customer.util;

import static com.inittech.customer.common.CustomerConstant.PHONE_NUMBER_VALUE_INVALID;
import static com.inittech.customer.common.CustomerConstant.EMAIL_SPLITTER;
import static com.inittech.customer.common.CustomerConstant.EMAIL_MASK;
import static com.inittech.customer.common.CustomerConstant.PHONE_NUMBER_MASK;
import static com.inittech.customer.common.CustomerConstant.SUCCESS;
import static com.inittech.customer.common.CustomerConstant.FAILURE;
import static com.inittech.customer.common.CustomerConstant.getKey;

public class StringMaskUtils {
	
	
	public static String phoneNumberMask(String phoneNumber) {
	
		String validationResponse = PhoneNumberValidationUtil.phoneNumberValidation(phoneNumber);
		if (SUCCESS.equalsIgnoreCase(validationResponse)) {
    		 return  buildMaskPhonumber(phoneNumber);
		}else if (FAILURE.equalsIgnoreCase(validationResponse)) {
			return getKey(PHONE_NUMBER_VALUE_INVALID);
		}else {
			 return validationResponse;
		}
	
	
	}
	
	public static String emailAddressMask(String email) {
		String validateResponse = EmailValidationUtil.emailValidation(email);
		if("Success".equalsIgnoreCase(validateResponse)) {
		String firstPart = email.split(EMAIL_SPLITTER)[0];
		String secoundPart = email.split(EMAIL_SPLITTER)[1];
	
		char[] tempFirstPart = formMaskEmail(firstPart);
		StringBuilder builder = new StringBuilder();
		builder.append(tempFirstPart);
		builder.append(EMAIL_SPLITTER);
		builder.append(secoundPart);
		return builder.toString();
		}else {
			return validateResponse;
		}
	}

	private static char[] formMaskEmail(String firstPart) {
		char[] tempFirstPart = new char[firstPart.length()];
		for (int i=0;i<tempFirstPart.length;i++) {
			if(firstPart.length()>=1 &&(i == 0 || i == firstPart.length()-1)) {
				tempFirstPart[i] =firstPart.charAt(i);
			}else {
				tempFirstPart[i] =EMAIL_MASK.charAt(0);
			}
		}
		return tempFirstPart;
	}

	private static String buildMaskPhonumber(String phoneNumber) {
		String maskedPhoneNumber;
		char[] phonenum = phoneNumber.substring(phoneNumber.length() - 5, phoneNumber.length()).toCharArray();
		switch (phonenum[0]) {
		case '-':
			maskedPhoneNumber = new String(maskPhoneNumber(phoneNumber, phonenum));
			break;
		case ' ':
			maskedPhoneNumber = new String(maskPhoneNumber(phoneNumber, phonenum));
			break;
		default:
			if (Character.isDigit(phonenum[0])) {
			maskedPhoneNumber = new String(maskPhoneNumberForDeigt(phoneNumber));
			}else {
			maskedPhoneNumber =	getKey(PHONE_NUMBER_VALUE_INVALID);
			}
			break;
		}
		return maskedPhoneNumber;
	}
	
	private static char[] maskPhoneNumber(String phoneNumber, char[] phonenum) {
		char[] maskArray = new char[phoneNumber.length()];
		for (int i = 0; i < phoneNumber.toCharArray().length; i++) {
			if (i > phoneNumber.lastIndexOf(phonenum[0]) - 4 && i < phoneNumber.lastIndexOf(phonenum[0])) {
				maskArray[i] = PHONE_NUMBER_MASK.charAt(0);
			} else {
				maskArray[i] = phoneNumber.toCharArray()[i];
			}
		}
		return maskArray;
	}

	private static char[] maskPhoneNumberForDeigt(String phoneNumber) {
		char[] maskArray = new char[phoneNumber.length()];

		for (int i = 0; i < phoneNumber.toCharArray().length; i++) {
			if (i > phoneNumber.length() - 8 && i < phoneNumber.length() - 4) {
				maskArray[i] = PHONE_NUMBER_MASK.charAt(0);
			} else {
				maskArray[i] = phoneNumber.toCharArray()[i];
			}
		}
		return maskArray;
	}

}
