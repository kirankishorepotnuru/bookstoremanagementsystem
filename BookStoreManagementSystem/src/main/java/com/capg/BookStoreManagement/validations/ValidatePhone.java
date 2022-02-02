package com.capg.BookStoreManagement.validations;

public class ValidatePhone {
	public boolean doValidatePhone(long userPhone) {
		
		String regex="^\\d{10}$";
		String phone=String.valueOf(userPhone);
	      boolean result=phone.matches(regex);
	      if(result) {
	    	  return true;
	      }
	      else {
	    	  return false;
	      }
	   }
	}