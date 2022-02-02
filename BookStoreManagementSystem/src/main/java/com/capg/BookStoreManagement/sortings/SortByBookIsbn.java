package com.capg.BookStoreManagement.sortings;

import java.util.Comparator;
import com.capg.BookStoreManagement.beans.Book;

public class SortByBookIsbn implements Comparator<Book>{
	public int compare(Book u1,Book u2) {
    	return u1.getIsbn() - u2.getIsbn();
	}
}