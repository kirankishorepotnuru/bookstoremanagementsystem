package com.capg.BookStoreManagement.validations;

public class ValidateEmail {
	public boolean doValidateEmail(String Email) {
	      String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	      //Matching the given phone number with regular expression
	      boolean result = Email.matches(regex);
	      if(result) {
	    	  return true;
	      } 
	      else {
	    	  return false;
	      }     
	}
}