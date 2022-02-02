package com.capg.BookStoreManagement.ui;

import java.util.List;
import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.beans.Cart;
import com.capg.BookStoreManagement.beans.Order;
import com.capg.BookStoreManagement.beans.User;

public class GetOutputs {
	public void PrintUserDetaisOfSearch(User user) {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %30s %20s %20s", "User_ID", "User_NAME", "User_Password", "User_Email", "User_Address", "User_Phone Number");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
			System.out.format("%10d %20s %20s %30s %20s %20s",user.getUserId(),user.getUserName(),user.getUserPwd(),user.getUserEmail(),user.getUserAddress(),user.getUserPhone());
			System.out.println();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void PrintUserDetaisOfSort(List<User> users) {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %30s %20s %20s", "User_ID", "User_NAME", "User_Password", "User_Email", "User_Address", "User_Phone Number");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		for (User user1 : users) {
			System.out.format("%10d %20s %20s %30s %20s %20s",user1.getUserId(),user1.getUserName(),user1.getUserPwd(),user1.getUserEmail(),user1.getUserAddress(),user1.getUserPhone());
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void PrintBookDetaisOfSearch(Book book) {
		System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %20s %20s", "Book_Isbn", "Book_Title", "Book_Author", "Book_Price", "Books_Quantity");
        System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.format("%10d %20s %20s %20s %20s",book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPrice(),book.getQty());
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------------");
	}
	
	public void PrintBookDetaisOfSort(List<Book> books) {
		System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %20s %20s", "Book_Isbn", "Book_Title", "Book_Author", "Book_Price", "Books_Quantity");
        System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (Book book : books) {
			System.out.format("%10d %20s %20s %20s %20s",book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPrice(),book.getQty());
			System.out.println();
		}			
		System.out.println("-----------------------------------------------------------------------------------------------------------");
	}
	
	public void PrintOrderDetaisOfSearch(List<Order> orders) {
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %15s %15s %15s %15s %15s", "User_ID", "Book_Isbn", "Book_Title", "Book_Quantity", "Total_Price", "Order_ID", "Order_Date", "Order_Time");
        System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		for (Order order : orders) {
			System.out.format("%10s %20s %20s %15s %15s %15s %15s %15s",order.getUserId(),order.getBookIsbn(),order.getBookTitle(),order.getBookQuantity(),order.getTotalPrice(),order.getOrderId(),order.getOrderDate(),order.getOrderTime());
			System.out.println();	
		}
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void PrintOrderDetaisOfSort(List<Order> orders) {
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %15s %15s %15s %15s %15s", "User_ID", "Book_Isbn", "Book_Title", "Book_Quantity", "Total_Price", "Order_ID", "Order_Date", "Order_Time");
        System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        for (Order order : orders) {
			System.out.format("%10s %20s %20s %15s %15s %15s %15s %15s",order.getUserId(),order.getBookIsbn(),order.getBookTitle(),order.getBookQuantity(),order.getTotalPrice(),order.getOrderId(),order.getOrderDate(),order.getOrderTime());
			System.out.println();
		}	
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void PrintCartDetais(List<Cart> cartOrders,int TotalOrderAmount) {
		System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %15s %15s", "User_ID", "Book_Isbn", "Book_Title", "Book_Quantity", "Total_Price");
        System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------");
		for (Cart cart : cartOrders) 
		{
			System.out.format("%10s %20s %20s %15s %15s",cart.getUserId(),cart.getBookIsbn(),cart.getBookTitle(),cart.getBookQuantity(),cart.getTotalPrice());
			System.out.println();
		}
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.format("%10s","Total_Order_Amount");
		System.out.format("%65s",TotalOrderAmount);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------");
	}
	
	public void PrintCanceledOrderDetais(List<Order> cancelOrders,int TotalRefundAmount) {
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %15s %15s %15s %15s %15s", "User_ID", "Book_Isbn", "Book_Title", "Book_Quantity", "Total_Price", "Order_ID", "Order_Date", "Order_Time");
        System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		for (Order CancelOrder : cancelOrders) {
			System.out.format("%10s %20s %20s %15s %15s %15s %15s %15s",CancelOrder.getUserId(),CancelOrder.getBookIsbn(),CancelOrder.getBookTitle(),CancelOrder.getBookQuantity(),CancelOrder.getTotalPrice(),CancelOrder.getOrderId(),CancelOrder.getOrderDate(),CancelOrder.getOrderTime());
			System.out.println();	
		}
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
			System.out.format("%10s","Total_Refund_Amount");
			System.out.format("%66s",TotalRefundAmount);
			System.out.println();
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	}
}