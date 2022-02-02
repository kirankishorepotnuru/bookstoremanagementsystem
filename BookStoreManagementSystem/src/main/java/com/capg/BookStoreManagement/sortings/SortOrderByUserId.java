package com.capg.BookStoreManagement.sortings;

import java.util.Comparator;
import com.capg.BookStoreManagement.beans.Order;

public class SortOrderByUserId implements Comparator<Order>{
	public int compare(Order u1,Order u2) {
    	return u1.getUserId() - u2.getUserId();
	}
}