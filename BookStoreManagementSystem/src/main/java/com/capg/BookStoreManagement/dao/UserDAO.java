package com.capg.BookStoreManagement.dao;

import java.sql.Time;
import java.text.ParseException;
import java.util.List;

import com.capg.BookStoreManagement.beans.Book;

import com.capg.BookStoreManagement.beans.Cart;

import com.capg.BookStoreManagement.beans.Order;

public interface UserDAO {
	
	public List<Book> getBooks();
 
    public Book doSearchBook(int isbn);
    public Book searchByBookTitle(String title);
    public Book doSearchBook(String author);
    
    public boolean doOrderBooks(Order od);
    
    public List<Order> viewOrdersByUseId(int UserId);
    
    public boolean doCartBooks(Cart ct);
    
    public List<Cart> DisplayCartOrders(int UserId);
    
    public boolean doCancelOrder(int UserId,int orderId);
    
    public boolean doEmptyCart(int UserId);
    
    public Integer doCalculateTotalOrderPrice(int UserId);
    
    public Integer GetOrderId();
    
    public java.util.Date GetCurrentDate() throws ParseException;
    public Time GetCurrentTime() throws ParseException;
    
    public void doUpdateBooksTotal(int Isbn,int Qty);
    
    public Integer getTotalBooks(int Isbn);
    
    public Integer getOrderQty(int userId,int orderId,int Isbn);
    
    public List<Integer> getOrderIsbn(int userId,int orderId);
    
    public List<Order> getCanceledOrders(int userId,int orderId);
    
    public Integer doCalculateTotalCancelOrderPrice(int userId,int orderId);
    
    public Integer doCalculateTotalPrice(int isbn,int BookQty);
}