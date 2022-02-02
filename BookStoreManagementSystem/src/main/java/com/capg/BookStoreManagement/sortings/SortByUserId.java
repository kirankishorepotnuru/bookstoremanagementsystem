package com.capg.BookStoreManagement.sortings;

import java.util.Comparator;
import com.capg.BookStoreManagement.beans.User;

public class SortByUserId implements Comparator<User>{
	public int compare(User u1,User u2) {
    	return u1.getUserId() - u2.getUserId();
	}
}