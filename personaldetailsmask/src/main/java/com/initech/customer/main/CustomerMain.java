package com.initech.customer.main;

import com.initech.customer.util.EmailValidationUtil;
import com.initech.customer.util.PhoneNumberValidationUtil;
import com.initech.customer.util.StringMaskUtils;


/***
 * This Main method is tempararly . it support for user to run this program.
 * @author anbus
 *
 */
public class CustomerMain {
	
	public static void main(String[] args) {
		
		if(args != null && args.length ==2) {
			
			switch (args[0]) {
			case "PHONE":
				 String phoneNumber  = StringMaskUtils.phoneNumberMask(args[1]);
				 System.out.println("Your Masked honeNumber will be --->"+phoneNumber);
				 break;
			case "EMAIL":
				 String email = StringMaskUtils.emailAddressMask(args[1]);
				 System.out.println("your Masked Email Address will be --->"+email);
				break;
			default:
				 System.out.println("Given Phone Number Or Email Invalid Input");
				break;
			}
		}else {
			 	System.out.println("Given Phone Number Or Email Invalid Input");
		}
		
	}

}
