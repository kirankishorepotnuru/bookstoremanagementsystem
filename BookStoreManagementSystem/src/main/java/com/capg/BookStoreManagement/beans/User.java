package com.capg.BookStoreManagement.beans;

public class User implements Comparable<User>{
	private int userId;
	private String userName;
	private String userPwd;
	private String userEmail;
	private String userAddress;
	private long userPhone;
	
	public User(int userId,String userName,String userPwd,String userEmail,String userAddress,long userPhone) {
		
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserPwd() {
		return userPwd;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public String getUserAddress() {
		return userAddress;
	}
	
	public long getUserPhone() {
		return userPhone;
	}
	
public int compareTo(User u) {
		return this.userId-u.userId;
	}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((userAddress == null) ? 0 : userAddress.hashCode());
	result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
	result = prime * result + userId;
	result = prime * result + ((userName == null) ? 0 : userName.hashCode());
	result = prime * result + (int) (userPhone ^ (userPhone >>> 32));
	result = prime * result + ((userPwd == null) ? 0 : userPwd.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (userAddress == null) {
		if (other.userAddress != null)
			return false;
	} else if (!userAddress.equals(other.userAddress))
		return false;
	if (userEmail == null) {
		if (other.userEmail != null)
			return false;
	} else if (!userEmail.equals(other.userEmail))
		return false;
	if (userId != other.userId)
		return false;
	if (userName == null) {
		if (other.userName != null)
			return false;
	} else if (!userName.equals(other.userName))
		return false;
	if (userPhone != other.userPhone)
		return false;
	if (userPwd == null) {
		if (other.userPwd != null)
			return false;
	} else if (!userPwd.equals(other.userPwd))
		return false;
	return true;
}



}