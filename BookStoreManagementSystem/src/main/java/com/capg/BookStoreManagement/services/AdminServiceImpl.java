package com.capg.BookStoreManagement.services;

import java.util.*;
import com.capg.BookStoreManagement.beans.Admin;
import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.beans.Order;
import com.capg.BookStoreManagement.beans.User;
import com.capg.BookStoreManagement.dao.AdminDAO;
import com.capg.BookStoreManagement.dao.AdminDAOImpl;
import com.capg.BookStoreManagement.exception.InvalidBookException;
import com.capg.BookStoreManagement.exception.InvalidOrderException;
import com.capg.BookStoreManagement.exception.InvalidUserException;

public class AdminServiceImpl implements AdminService{
	
	Admin as=new Admin();
	AdminDAO ad=new AdminDAOImpl();
	
	public boolean doAddUser(User user)throws InvalidUserException {
				boolean isUserAdded=ad.doAddUser(user);
				return isUserAdded;
	}
	
	public boolean doModifyUser(User user)throws InvalidUserException {
				boolean isUserModified=ad.doModifyUser(user);
				return isUserModified;
	}
	
	public boolean doDeleteUser(int userId) throws InvalidUserException 
	{
			boolean isBookDeleted=ad.doDeleteUser(userId);
			return isBookDeleted;
	}
	
	public User doSearchUser(int userID) throws InvalidUserException{
		User isUserSearch=ad.doSearchUser(userID);
		return isUserSearch;
	}
	
	public User doSearchUser(String userName) throws InvalidUserException
	{
		User isUserSearch=ad.doSearchUser(userName);
		return isUserSearch;
	}
	
	public boolean doAddBooks(Book book) throws InvalidBookException{
				boolean isBookAdded=ad.doAddBooks(book);
				return isBookAdded;
	}
	
	 public boolean doDeleteBooks(int isbn) throws InvalidBookException{
		 boolean isBookDeleted=ad.doDeleteBooks(isbn);
			return isBookDeleted;
	 }
	 
	public boolean doEditBooks(Book book) throws InvalidBookException{
				boolean isBookEdited=ad.doEditBooks(book);
				return isBookEdited;
	}
	
	public Book doSearchBook(int Isbn) throws InvalidBookException
	{
		Book isBookSearch=ad.doSearchBook(Isbn);
		return isBookSearch;
	}
	
	public Book doSearchBook(String author) throws InvalidBookException{
		Book isBookSearch=ad.doSearchBook(author);
		return isBookSearch;
	}
	
	public Book searchByBookTitle(String title) throws InvalidBookException{
		Book isBookSearch=ad.searchByBookTitle(title);
		return isBookSearch;
	}
	
	public List<User> getUsers() throws InvalidUserException {
		List<User> allBooks=ad.getUsers();
		return allBooks;
	}
	
	public List<User> getUsersByRange(int userId1,int userId2){
		List<User> allUsers=null;
		if(userId1<userId2)
		{
			allUsers=ad.getUsersByRange(userId1,userId2);
			return allUsers;
		}
		else
		{
			return null;
		}
	}
	
	public List<Book> getBooks() throws InvalidBookException
	{
		List<Book> allBooks=ad.getBooks();
		return allBooks;
	}
	
	public List<Order> getOrders() throws InvalidOrderException {
		List<Order> allOrders=ad.getOrders();
		return allOrders;
	}

	public  List<Order> doSearchOrderByOrderDate(String orderDate) throws InvalidOrderException {
		 List<Order> isOrderSearch=ad.doSearchOrderByOrderDate(orderDate);
		return isOrderSearch;
	}
	
	public List<Order> doSearchOrderByOrderId(int orderId) throws InvalidOrderException {
		List<Order> isOrderSearch=ad.doSearchOrderByOrderId(orderId);
		return isOrderSearch;
	}
	
	public List<Order> doSearchOrderByUserId(int userId) throws InvalidOrderException {
		List<Order> isOrderSearch=ad.doSearchOrderByUserId(userId);
		return isOrderSearch;
	}
}