package com.capg.BookStoreManagement.beans;

public class Admin {
	
	public String UserNameSaved="Admin";
	public  String PasswordSaved="Admin@123";
	private String UserNameEntered;
	private String PasswordEntered;
	
	public String getUserNameEntered() {
		return UserNameEntered;
	}

	public void setUserNameEntered(String userNameEntered) {
		UserNameEntered = userNameEntered;
	}

	public String getPasswordEntered() {
		return PasswordEntered;
	}

	public void setPasswordEntered(String passwordEntered) {
		PasswordEntered = passwordEntered;
	}	
}