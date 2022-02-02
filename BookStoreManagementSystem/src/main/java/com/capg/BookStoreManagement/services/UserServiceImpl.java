package com.capg.BookStoreManagement.services;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.List;
import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.beans.Cart;
import com.capg.BookStoreManagement.beans.Order;
import com.capg.BookStoreManagement.beans.User;
import com.capg.BookStoreManagement.dao.UserDAOImpl;
import com.capg.BookStoreManagement.exception.InvalidBookException;
import com.capg.BookStoreManagement.exception.InvalidUserException;

public class UserServiceImpl implements UserService{
	
	UserDAOImpl ad=new UserDAOImpl();
	
	public boolean doAddUser(User user)throws InvalidUserException {
		boolean isUserModified=ad.doRegisterUser(user);
		return isUserModified;
		}
	
	public List<Book> getBooks() throws InvalidBookException {
		List<Book> allBooks=ad.getBooks();
		return allBooks;
	}
	
	public Book doSearchBook(int Isbn) throws InvalidBookException{
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
	
	public boolean doOrderBooks(Order od) {
		boolean isBookOrdered=ad.doOrderBooks(od);
		return isBookOrdered;
	}
	
	public boolean doCartBooks(Cart od) {
		boolean isBookCarted=ad.doCartBooks(od);
		return isBookCarted;
	}
	
	public List<Order> viewOrdersByUseId(int UserId) {
		List<Order> allOrders=ad.viewOrdersByUseId(UserId);
		return allOrders;
	}
	
	public List<Cart> DisplayCartOrders(int UserId) {
		List<Cart> cartOrders=ad.DisplayCartOrders(UserId);
		return cartOrders;
	}
	
	public int doCalculateTotalPrice(int isbn,int qty) {
		int TotalPrice=ad.doCalculateTotalPrice(isbn,qty);
		return TotalPrice;
	}
	
	public Integer doCalculateTotalOrderPrice(int UserId) {
		int TotalOrderPrice=ad.doCalculateTotalOrderPrice(UserId);
		return TotalOrderPrice;
	}
	
	public boolean doEmptyCart(int userId){
			boolean isCartEmpty=ad.doEmptyCart(userId);
			return isCartEmpty;
	}
	
	public Integer GetOrderId() {
		int orderId=ad.GetOrderId();
		return orderId;
	}
	
	public Date GetCurrentDate() throws ParseException {
		Date CurrentDate=ad.GetCurrentDate();
		return CurrentDate;
	}
	
	public Time GetCurrentTime() throws ParseException {
		Time CurrentTime=ad.GetCurrentTime();
		return CurrentTime;
	}
	
	public boolean doCancelOrder(int userId,int orderId){
			boolean isOrderCanceled=ad.doCancelOrder(userId,orderId);
			return isOrderCanceled;
	}
	
	public void doUpdateBooksTotal(int Qty,int Isbn) throws InvalidBookException 
	{
		ad.doUpdateBooksTotal(Qty, Isbn);
	}
	
	public Integer getTotalBooks(int Isbn) throws InvalidBookException {
		int TotalBooks=ad.getTotalBooks(Isbn);
		return TotalBooks;
	}
	
	public Integer getOrderQty(int userId,int orderId,int Isbn) {
		int OrderQty=ad.getOrderQty(userId,orderId,Isbn);
		return OrderQty;
	}
	
	public List<Integer> getOrderIsbn(int userId,int orderId){
		List<Integer> OrderIsbn=ad.getOrderIsbn(userId, orderId);
		return OrderIsbn;
	}
	
	public List<Order> getCanceledOrders(int userId,int orderId){
		List<Order> CanceledOrders=ad.getCanceledOrders(userId, orderId);
		return CanceledOrders;
	}
	
	public Integer doCalculateTotalCancelOrderPrice(int userId,int orderId) {
		int TotalCancelOrderPrice=ad.doCalculateTotalCancelOrderPrice(userId,orderId);
		return TotalCancelOrderPrice;
	}
}