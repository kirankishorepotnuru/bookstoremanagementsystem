package com.capg.BookStoreManagement.services;

import java.util.List;

import com.capg.BookStoreManagement.beans.Book;

import com.capg.BookStoreManagement.beans.Order;

import com.capg.BookStoreManagement.beans.User;

import com.capg.BookStoreManagement.exception.InvalidBookException;

import com.capg.BookStoreManagement.exception.InvalidOrderException;

import com.capg.BookStoreManagement.exception.InvalidUserException;

public interface AdminService {
	
	public boolean doAddUser(User user) throws InvalidUserException;
	
	public boolean doModifyUser(User user)throws InvalidUserException;
	
	public boolean doDeleteUser(int userId) throws InvalidUserException;
	
    public boolean doAddBooks(Book book) throws InvalidBookException;
    
    public boolean doEditBooks(Book book) throws InvalidBookException;
    
    public boolean doDeleteBooks(int isbn) throws InvalidBookException;
    
    public User doSearchUser(int userId) throws InvalidUserException;
    public User doSearchUser(String userName) throws InvalidUserException;
    
    public Book doSearchBook(int isbn) throws InvalidBookException;
    public Book searchByBookTitle(String title) throws InvalidBookException;
    public Book doSearchBook(String author) throws InvalidBookException;
    
    public List<User> getUsers() throws InvalidUserException;
    public List<User> getUsersByRange(int userId1,int userId2) throws InvalidUserException;
    
    public List<Book> getBooks() throws InvalidBookException;
   
    
    public List<Order> getOrders() throws InvalidOrderException;
  
    public List<Order> doSearchOrderByOrderDate(String orderDate) throws InvalidOrderException;
    public List<Order> doSearchOrderByOrderId(int orderId) throws InvalidOrderException;
    public List<Order> doSearchOrderByUserId(int userId) throws InvalidOrderException;
    
}
