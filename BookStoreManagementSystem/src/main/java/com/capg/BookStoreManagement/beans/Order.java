package com.capg.BookStoreManagement.beans;

import java.sql.Date;
import java.sql.Time;


public class Order {
	public int userId;
	public long bookIsbn;
	public String bookTitle;
	public int bookQuantity;
	public int totalPrice;
	public int orderId;
	public Date orderDate;
	public Time orderTime;
	
	public Order(int userId,long bookIsbn,String bookTitle,int bookQuantity,int totalPrice,int orderId,Date orderDate,Time orderTime) {
		this.userId = userId;
		this.bookIsbn = bookIsbn;
		this.bookTitle = bookTitle;
		this.bookQuantity = bookQuantity;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public long getBookIsbn() {
		return bookIsbn;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public int getBookQuantity() {
		return bookQuantity;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public Time getOrderTime() {
		return orderTime;
	}
	
}