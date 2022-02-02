package com.capg.BookStoreManagement.dao;

import java.util.List;
import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.beans.Order;
import com.capg.BookStoreManagement.beans.User;

public interface AdminDAO {
	
	public boolean doAddUser(User user);
	
	public boolean doModifyUser(User user);
    
	public boolean doDeleteUser(int userId);
    
    public boolean doAddBooks(Book book);
    
    public boolean doEditBooks(Book book);
    
    public boolean doDeleteBooks(int isbn);
    
    public User doSearchUser(int userId);
    public User doSearchUser(String userName);
    
    public Book doSearchBook(int isbn);
    public Book searchByBookTitle(String title);
    public Book doSearchBook(String author);
    
    public List<User> getUsers();
    public List<User> getUsersByRange(int userId1,int userId2);
    
    public List<Book> getBooks();
    
    public List<Order> getOrders();
   
    public List<Order> doSearchOrderByOrderDate(String orderDate);
    public List<Order> doSearchOrderByOrderId(int orderId);
    public List<Order> doSearchOrderByUserId(int userId);  
    
}