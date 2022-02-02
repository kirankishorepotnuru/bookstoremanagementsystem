package com.capg.BookStoreManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.beans.Cart;
import com.capg.BookStoreManagement.beans.Order;
import com.capg.BookStoreManagement.beans.User;
import com.capg.BookStoreManagement.util.DBConnection;

public class UserDAOImpl implements UserDAO{
	Connection con = DBConnection.con;
    PreparedStatement ps;
	public boolean doRegisterUser(User user)
    {
		    try
		    {
		        ps = con.prepareStatement("insert into user values (?,?,?,?,?,?)");
		        ps.setInt(1,user.getUserId());
		        ps.setString(2,user.getUserName());
		        ps.setString(3,user.getUserPwd());
		        ps.setString(4,user.getUserEmail());
		        ps.setString(5,user.getUserAddress());
		        ps.setLong(6,user.getUserPhone());
		        int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
				if(i==1) return true;
				return false;
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Exception while Insertion of User "+e);
		    }
		    return false;
		 }
	public List<Book> getBooks()
	 {
		 String sqlQuery="Select * from Book order by isbn";
		 List<Book> booksList=new ArrayList<Book>();
		 try
		 {
			 ps=con.prepareStatement(sqlQuery);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 int isbn=rs.getInt("isbn");
				 String title=rs.getString("title");
				 String author=rs.getString("author");
				 int price=rs.getInt("price");
				 int qty=rs.getInt("qty");
				 Book bp=new Book(isbn,title,author,price,qty);
				 booksList.add(bp);
			 }
			 return booksList;
		 }
		 catch (Exception e) {
			 System.out.println("exception in sorting");
		}
		return null;
		 
	 }
	
	public Book doSearchBook(int Isbn) {
		 try {
		 ps=con.prepareStatement("select * from book where isbn=?");
		 ps.setInt(1,Isbn);
		 ResultSet rs = ps.executeQuery(); // DML, i holds the value :- number of rows effected
			while(rs.next()) {
				int isbn = rs.getInt("isbn");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int price = rs.getInt("price");
				int qty = rs.getInt("qty");
				Book b=new Book(isbn,title,author,price,qty);
				return b;
			}
		 }
			 catch(Exception e) {
				 System.out.println("Exception while Searching Book");
			 }
			 return null;
	    }
	 
	 public Book doSearchBook(String author)
	 {
		 try {
			 ps=con.prepareStatement("select * from book where author=?");
			 ps.setString(1,author);
			 
			 ResultSet rs = ps.executeQuery(); // DML, i holds the value :- number of rows effected
				while(rs.next()) {
					int isbn = rs.getInt("isbn");
					String title = rs.getString("title");
					String authorSearch = rs.getString("author");
					int price = rs.getInt("price");
					int qty = rs.getInt("qty");
					Book b=new Book(isbn,title,authorSearch,price,qty);
					return b;
				}
			 }
				 catch(Exception e) {
					 System.out.println("Exception while Searching Book by author");
				 }
				 return null;
	 }
	 
	 public Book searchByBookTitle(String title)
	 {
		 try {
			 ps=con.prepareStatement("select * from book where title=?");
			 ps.setString(1,title);
			 
			 ResultSet rs = ps.executeQuery(); // DML, i holds the value :- number of rows effected
				while(rs.next()) {
					int isbn = rs.getInt("isbn");
					String Title = rs.getString("title");
					String authorSearch = rs.getString("author");
					int price = rs.getInt("price");
					int qty = rs.getInt("qty");
					Book b=new Book(isbn,Title,authorSearch,price,qty);
					return b;
				}
			 }
				 catch(Exception e) {
					 System.out.println("Exception while Searching Book by Title");
				 }
				 return null;
	 }
	 
	  public boolean doOrderBooks(Order od) {
		  try
		    {
		        ps = con.prepareStatement("insert into bookstoremanagement.order values (?,?,?,?,?,?,?,?)");
		        ps.setInt(1,od.getUserId());
		        ps.setLong(2,od.getBookIsbn());
		        ps.setString(3,od.getBookTitle());
		        ps.setInt(4,od.getBookQuantity());
		        ps.setInt(5,od.getTotalPrice());
		        ps.setInt(6,od.getOrderId());
		        ps.setDate(7, od.getOrderDate());
		        ps.setTime(8, od.getOrderTime());
		        int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
				if(i==1) return true;
				return false;
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Exception while Ordering Book "+e);
		    }
		    return false;
		 }
	  
	  public boolean doCartBooks(Cart ct) {
		  try
		    {
		        ps = con.prepareStatement("insert into bookstoremanagement.cart values (?,?,?,?,?)");
		        ps.setInt(1,ct.getUserId());
		        ps.setLong(2,ct.getBookIsbn());
		        ps.setString(3,ct.getBookTitle());
		        ps.setInt(4,ct.getBookQuantity());
		        ps.setInt(5,ct.getTotalPrice());
		        //ps.setInt(6,ct.getOrderId());
		        int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
				if(i==1) return true;
				return false;
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Exception while Adding Book to Cart "+e);
		    }
		    return false;
		 }
	  
	  
	  public List<Order> viewOrdersByUseId(int UserId)
		 {
		  try {
				List<Order> ordersList=new ArrayList<Order>();
				 ps=con.prepareStatement("select * from bookstoremanagement.order where userId=?");
				 ps.setInt(1,UserId);
				 
				 ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						int UserID=rs.getInt("userId");
						long Isbn = rs.getInt("bookIsbn");
						String Title = rs.getString("bookTitle");
						int qty = rs.getInt("bookQuantity");
						int TotalPrice=rs.getInt("totalPrice");
						int OrderId=rs.getInt("orderId");
						Date OrderDate=rs.getDate("orderDate");
						Time OrderTime=rs.getTime("orderTime");
						Order o=new Order(UserID,Isbn,Title,qty,TotalPrice,OrderId,OrderDate,OrderTime);
						ordersList.add(o);
					}
					return ordersList;
				 }
					 catch(Exception e) {
						 System.out.println("Exception while View Order by UserId");
					 }
					 return null;
		 }
	  
	  public List<Cart> DisplayCartOrders(int UserId)
		 {
		  try {
				List<Cart> cartList=new ArrayList<Cart>();
				 ps=con.prepareStatement("select * from bookstoremanagement.cart where userId=?");
				 ps.setInt(1,UserId);
				 
				 ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						int UserID=rs.getInt("userId");
						int Isbn = rs.getInt("bookIsbn");
						String Title = rs.getString("bookTitle");
						int qty = rs.getInt("bookQuantity");
						int TotalPrice=rs.getInt("totalPrice");
						Cart c=new Cart(UserID,Isbn,Title,qty,TotalPrice);
						cartList.add(c);
					}
					return cartList;
				 }
					 catch(Exception e) {
						 System.out.println("Exception while View Order by UserId");
					 }
					 return null;
		 }
	  
	  public boolean doCancelOrder(int userId,int orderId) {
			 
		    try
		    {
		        ps = con.prepareStatement("delete from bookstoremanagement.order where userId=? and orderId=?");
		        ps.setInt(1,userId);
		        ps.setInt(2,orderId);
		        int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
				if(i>0) return true;
				return false;
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Exception while Canceling Order "+e);		    
		    	}
		    return false;
	    }
		public boolean doEmptyCart(int UserId) {
			 
		    try
		    {
		        ps = con.prepareStatement("delete from bookstoremanagement.cart where userId=?");
		        ps.setInt(1,UserId);
		        int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
				if(i>0) return true;
				return false;
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Exception while Empty Cart "+e);		    
		    	}
		    return false;
	    }
		
	  public Integer doCalculateTotalPrice(int isbn,int BookQty) {
		  try {
				 int BookPrice=0;
			ps=con.prepareStatement("select price from book where isbn=?");
			 ps.setInt(1,isbn);
			 
			 ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					BookPrice = rs.getInt("price");
				}
				int TotalPrice=BookPrice*BookQty;
				return TotalPrice;
			 }
				 catch(Exception e) {
					 System.out.println("Exception while Calculating Total Cart Item Price");
				 }
		  return null;
		    }
	  
	  public Integer doCalculateTotalOrderPrice(int UserId) {
		  try {
				 int BookPrice=0;
				 int TotalOrderPrice=0;
			ps=con.prepareStatement("select totalPrice from cart where userId=?");
			 ps.setInt(1,UserId);
			 ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					BookPrice = rs.getInt("totalPrice");
					TotalOrderPrice+=BookPrice;
				}
				
				return TotalOrderPrice;
			 }
				 catch(Exception e) {
					 System.out.println("Exception while Calculating Total Order Price");
				 }
		  return null;
		    }
	  
	  public Integer GetOrderId() {
		  
		  try {
			 int OrderID=0;
			ps=con.prepareStatement("select orderId from bookstoremanagement.order");
			 ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					OrderID = rs.getInt("orderId");
					}
				return OrderID;
				
			 }
				 catch(Exception e) {
					 System.out.println("Exception while Getting OrderId");
				 }
		  return null;
		    }
	  
	  public Integer getTotalBooks(int Isbn) {
		  try {
				int TotalBooks=0;
				 ps=con.prepareStatement("select * from book where isbn=?");
				 ps.setInt(1,Isbn);
				 ResultSet rs = ps.executeQuery(); // DML, i holds the value :- number of rows effected
					while(rs.next()) {
						TotalBooks=rs.getInt("qty");	
						}
					return TotalBooks;
					
					}
					 catch(Exception e) {
						 System.out.println("Exception while getting Total Books");
					 }
					 return null;
		 }
	  
	  public void doUpdateBooksTotal(int Qty,int Isbn) {
		  try
		    {
		        ps = con.prepareStatement("update book set qty=? where isbn=?");
		        ps.setInt(1,Qty);
		        ps.setInt(2, Isbn);
		        ps.executeUpdate();
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Exception while Updating Total Books "+e);
		    }
	  }
	  public Date GetCurrentDate() throws ParseException {
		 try {
			 java.util.Date date=new java.util.Date();
			 java.sql.Date sqlDate=new java.sql.Date(date.getTime());
			 //java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
			 return sqlDate;
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return null;
	  }
	  
	  public Time GetCurrentTime() throws ParseException {
			 try {
				 java.util.Date date=new java.util.Date();
				 //java.sql.Date sqlDate=new java.sql.Date(date.getTime());
				 Time sqlTime=new java.sql.Time(date.getTime());
				 return sqlTime;
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
			 return null;
		  }
		 /* SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		  LocalDate date=LocalDate.now();
		  String date1=formatter.format(date);
		  Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(date1);
		  return date2;
		    }*/
	  
	  public Integer getOrderQty(int userId,int orderId,int Isbn) {
		  try {
			     int OrderQty=0;
				 ps=con.prepareStatement("select * from bookstoremanagement.order where userId=? and orderId=?");
				 ps.setInt(1,userId);
				 ps.setInt(2,orderId);
				 ResultSet rs = ps.executeQuery(); // DML, i holds the value :- number of rows effected
					while(rs.next()) {
						OrderQty=rs.getInt("bookQuantity");	
						}
					return OrderQty;
					
					}
					 catch(Exception e) {
						 System.out.println("Exception while getting Order Quantity");
					 }
					 return null;
		 }
	  public List<Integer> getOrderIsbn(int userId,int orderId) {
		  try {
			    List<Integer> OrderISBN=new ArrayList<Integer>();
			     int OrderIsbn=0;
				 ps=con.prepareStatement("select * from bookstoremanagement.order where userId=? and orderId=?");
				 ps.setInt(1,userId);
				 ps.setInt(2,orderId);
				 ResultSet rs = ps.executeQuery(); // DML, i holds the value :- number of rows effected
					while(rs.next()) {
						OrderIsbn=rs.getInt("bookIsbn");	
						OrderISBN.add(OrderIsbn);
						}
						
					return OrderISBN;
					
					}
					 catch(Exception e) {
						 System.out.println("Exception while getting Order Isbn");
					 }
					 return null;
		 }
	  
	  public List<Order> getCanceledOrders(int userId,int orderId){

		  
		  try
			 {
			  List<Order> canceledOrders=new ArrayList<Order>();
				ps=con.prepareStatement("Select * from bookstoremanagement.order where userId=? and orderId=?");
			     ps.setInt(1,userId);
				 ps.setInt(2,orderId);
				 ResultSet rs=ps.executeQuery();
				 while(rs.next())
				 {
					 int UserId=rs.getInt("userId");
					 int Isbn=rs.getInt("bookIsbn");
					 String title=rs.getString("bookTitle");
					 int qty=rs.getInt("bookQuantity");
					 int totalPrice=rs.getInt("totalPrice");
					 int OrderId=rs.getInt("orderId");
					 Date orderDate=rs.getDate("orderDate");
					 Time orderTime=rs.getTime("orderTime");
					 Order od=new Order(UserId,Isbn,title,qty,totalPrice,OrderId,orderDate,orderTime);
					 canceledOrders.add(od);
				 }
				 return canceledOrders;
			 }
			 catch (Exception e) {
				 System.out.println("exception in sorting Orders");
			}
			return null;
	  }
	  
	  public Integer doCalculateTotalCancelOrderPrice(int userId,int orderId) {
		  try {
			  int BookPrice=0;
				 int TotalCancelOrderPrice=0;
			ps=con.prepareStatement("Select totalPrice from bookstoremanagement.order where userId=? and orderId=?");
			 ps.setInt(1,userId);
			 ps.setInt(2,orderId);
			 
			 ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					BookPrice = rs.getInt("totalPrice");
					TotalCancelOrderPrice+=BookPrice;
				}
				
				return TotalCancelOrderPrice;
			 }
				 catch(Exception e) {
					 System.out.println("Exception while Calculating Total Cancel Order Price");
				 }
		  return null;
		    }
	  }