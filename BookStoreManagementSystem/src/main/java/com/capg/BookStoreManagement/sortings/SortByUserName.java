package com.capg.BookStoreManagement.sortings;

import java.util.Comparator;
import com.capg.BookStoreManagement.beans.User;

public class SortByUserName implements Comparator<User>{
	public int compare(User u1,User u2) {
    	return u1.getUserName().compareTo(u2.getUserName());
	}
}