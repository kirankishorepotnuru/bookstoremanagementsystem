package com.capg.BookStoreManagement.validations;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.capg.BookStoreManagement.util.DBConnection;

public class ValidateUserLogin {
	
	public boolean doValidateUser(Integer UserID,String password) {
		
		Connection con = DBConnection.con;
	    PreparedStatement ps;
	    
		 try {
			 
			 int UserId=0;
			 String UserPwd=null;
		ps=con.prepareStatement("select userId,userPwd from user where userId=?");
		 ps.setInt(1,UserID);
		 ResultSet rs = ps.executeQuery();
		 
			while(rs.next()) {
				UserId = rs.getInt("userId");
				UserPwd = rs.getString("userPwd");
			}
			
			if(UserID==UserId && password.equals(UserPwd)){
				return true;
			}
			else {
				return false;
			}
		 }
			 catch(Exception e) {
				 System.out.println("Exception while User Login");
			 }
			 return false;
	    }
}
