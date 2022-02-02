package com.capg.BookStoreManagement.services;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.List;

import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.beans.Cart;
import com.capg.BookStoreManagement.beans.Order;
import com.capg.BookStoreManagement.exception.InvalidBookException;
import com.capg.BookStoreManagement.exception.InvalidCartException;
import com.capg.BookStoreManagement.exception.InvalidOrderException;

public interface UserService {
	public List<Book> getBooks() throws InvalidBookException;
   
    public Book doSearchBook(int isbn) throws InvalidBookException;
    public Book searchByBookTitle(String title) throws InvalidBookException;
    public Book doSearchBook(String author) throws InvalidBookException;
    
    public boolean doOrderBooks(Order od) throws InvalidOrderException;
    
    public List<Order> viewOrdersByUseId(int UserId) throws InvalidOrderException;
    
    public boolean doCartBooks(Cart ct) throws InvalidCartException;
    
    public boolean doCancelOrder(int UserId,int orderId) throws InvalidOrderException;
    
    public boolean doEmptyCart(int UserId) throws InvalidCartException;
    
    public List<Cart> DisplayCartOrders(int UserId) throws InvalidCartException;
    
    public Integer doCalculateTotalOrderPrice(int UserId) throws InvalidOrderException;
    
    public Integer GetOrderId() throws InvalidOrderException;
    
    public Date GetCurrentDate() throws ParseException;
    public Time GetCurrentTime() throws ParseException;
    
    public void doUpdateBooksTotal(int Qty,int Isbn) throws InvalidBookException;
    
    public Integer getTotalBooks(int Isbn) throws InvalidBookException;
    
    public Integer getOrderQty(int userId,int orderId,int Isbn) throws InvalidOrderException;
    
    public List<Integer> getOrderIsbn(int userId,int orderId);
    
    public List<Order> getCanceledOrders(int userId,int orderId);
    
    public Integer doCalculateTotalCancelOrderPrice(int userId,int orderId);
    
    public int doCalculateTotalPrice(int isbn,int qty) throws InvalidOrderException;
}