package com.capg.BookStoreManagement.beans;

public class Cart {
	int userId;
	int bookIsbn;
	String bookTitle;
	int bookQuantity;
	int totalPrice;
	
	public Cart(int userId,int isbn,String bookTitle,int bookQuantity,int totalPrice)
	{
		this.userId = userId;
		this.bookIsbn = isbn;
		this.bookTitle = bookTitle;
		this.bookQuantity = bookQuantity;
		this.totalPrice = totalPrice;
	}
	
	public int getUserId() 
	{
		return userId;
	}
	
	public int getBookIsbn() {
		return bookIsbn;
	}
	
	public String getBookTitle() 
	{
		return bookTitle;
	}
	
	public int getBookQuantity() {
		return bookQuantity;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
}
