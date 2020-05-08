package com.inittech.customer.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class CustomerConstant {

	
	
	private static Map<String, String> messages = new HashMap<>();
	public static final int EMAIL_LENGTH = 80;
	public static final String EMAIL_VALUE_LENGTH_INVALID = "customer.email.length";
	public static final String EMAIL_VALUE_EMPTY_NULL = "customer.email.empty";
	public static final String EMAIL_VALUE_INVALID = "customer.email.invalid";
	public static final String PHONE_NUMBER_VALUE_EMPTY_NULL = "customer.phone.empty";
	public static final String PHONE_NUMBER_VALUE_INVALID_FORMAT = "customer.phone.format";
	public static final String PHONE_NUMBER_VALUE_INVALID = "customer.phone.invalid";
	public static final String EMAIL_SPLITTER = "@";
	public static final String PHONE_NUMBER_MASK = "#";
	public static final String EMAIL_MASK = "*";
	public static final String PHONE_NUMBER_REGX_FORMAT = "^\\+?\\d?{1,3}[-\\s]?[(]?\\d{3}[)]?[-\\s]?\\d{3}[-\\s]?[0-9A-Z]{4}$";
	public static final String EMAIL_REGX_FORMAT = "([^@]+)@(.*)\\.(.*)";
	public static final String SUCCESS = "Success";
	public static final String FAILURE = "Failure";
	public static String getKey(String key) {

		return messages.get(key);
	}

	private static Properties loadProperties() {

		try (InputStream input = CustomerConstant.class.getClassLoader().getResourceAsStream("message.properties")) {
			Properties prop = new Properties();

			if (input == null) {
				System.out.println("Sorry, unable to find message.properties");
				return null;
			}

			prop.load(input);
			return prop;
		} catch (IOException ex) {

		}
		return null;

	}
	
	

	static {
		Properties PROPERTIES = CustomerConstant.loadProperties();
		if(PROPERTIES != null) {
		messages.put(EMAIL_VALUE_LENGTH_INVALID, PROPERTIES.getProperty(EMAIL_VALUE_LENGTH_INVALID));
		messages.put(EMAIL_VALUE_EMPTY_NULL, PROPERTIES.getProperty(EMAIL_VALUE_EMPTY_NULL));
		messages.put(EMAIL_VALUE_INVALID, PROPERTIES.getProperty(EMAIL_VALUE_INVALID));
		messages.put(PHONE_NUMBER_VALUE_EMPTY_NULL, PROPERTIES.getProperty(PHONE_NUMBER_VALUE_EMPTY_NULL));
		messages.put(PHONE_NUMBER_VALUE_INVALID_FORMAT, PROPERTIES.getProperty(PHONE_NUMBER_VALUE_INVALID_FORMAT));
		messages.put(PHONE_NUMBER_VALUE_INVALID, PROPERTIES.getProperty(PHONE_NUMBER_VALUE_INVALID));
		}
	}

}
