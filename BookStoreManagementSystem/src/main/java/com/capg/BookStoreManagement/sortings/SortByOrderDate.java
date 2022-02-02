package com.capg.BookStoreManagement.sortings;

import java.util.Comparator;
import com.capg.BookStoreManagement.beans.Order;

public class SortByOrderDate implements Comparator<Order>{
	public int compare(Order o1,Order o2) {
		return o1.getOrderDate().compareTo(o2.getOrderDate());
	}
}