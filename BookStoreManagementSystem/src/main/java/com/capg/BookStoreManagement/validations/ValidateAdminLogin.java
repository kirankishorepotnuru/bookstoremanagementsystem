package com.capg.BookStoreManagement.validations;

import com.capg.BookStoreManagement.beans.Admin;

public class ValidateAdminLogin {
	Admin as=new Admin();
	public boolean doValidateAdmin(String adminName,String adminPassword) {
		if(adminName.equals(as.UserNameSaved) && adminPassword.equals(as.PasswordSaved)) {
			return true;
		}
		else {
			return false;
		}
	}
}