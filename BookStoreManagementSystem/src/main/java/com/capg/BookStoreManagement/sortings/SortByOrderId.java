package com.capg.BookStoreManagement.sortings;

import java.util.Comparator;
import com.capg.BookStoreManagement.beans.Order;

public class SortByOrderId implements Comparator<Order>{
	public int compare(Order o1,Order o2) {
    	return o1.getOrderId() - o2.getOrderId();
	}
}