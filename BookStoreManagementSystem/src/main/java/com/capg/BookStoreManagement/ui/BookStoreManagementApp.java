package com.capg.BookStoreManagement.ui;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.beans.Cart;
import com.capg.BookStoreManagement.beans.Order;
import com.capg.BookStoreManagement.beans.User;
import com.capg.BookStoreManagement.dao.AdminDAOImpl;
import com.capg.BookStoreManagement.exception.InvalidAdminException;
import com.capg.BookStoreManagement.exception.InvalidBookException;
import com.capg.BookStoreManagement.exception.InvalidCartException;
import com.capg.BookStoreManagement.exception.InvalidOrderException;
import com.capg.BookStoreManagement.exception.InvalidUserException;
import com.capg.BookStoreManagement.services.AdminServiceImpl;
import com.capg.BookStoreManagement.validations.*;
import com.capg.BookStoreManagement.services.UserServiceImpl;
import com.capg.BookStoreManagement.sortings.*;
public class BookStoreManagementApp {
	Scanner sc=new Scanner(System.in);
	static Scanner scr=new Scanner(System.in);
	AdminDAOImpl adminobj=new AdminDAOImpl();
	AdminServiceImpl asi=new AdminServiceImpl();
	UserServiceImpl usi=new UserServiceImpl();
	ValidateEmail ve=new ValidateEmail();
	ValidatePhone vp=new ValidatePhone();
	ValidateAdminLogin val=new ValidateAdminLogin();
	ValidateUserLogin vul=new ValidateUserLogin();
	GetOutputs go=new GetOutputs();
	public boolean status;
	User status1;
	Book status2;
	boolean Orderstatus;
	public static void main(String[] args) throws InvalidUserException, InvalidAdminException, InvalidBookException, InvalidOrderException,InvalidCartException, ParseException{
		BookStoreManagementApp bsm=new BookStoreManagementApp();
		bsm.LoginPage();
	}
	
	public void LoginPage() throws InvalidUserException, InvalidAdminException, InvalidBookException, InvalidOrderException,InvalidCartException, ParseException {
		BookStoreManagementApp app=new BookStoreManagementApp();
		ValidateEmail ve1=new ValidateEmail();
		ValidatePhone vp1=new ValidatePhone();
		
		while(true)
	    {
	    	System.out.println("\n\n****** BOOKSTORE MANAGEMENT SYSTEM ******");
	    	System.out.println("1.Admin Login");
	    	System.out.println("2.User Login");
	    	System.out.println("0.EXIT ");
	    	System.out.println("Enter your choice :");
	    	int choice=app.sc.nextInt();
	    	switch (choice) {
			case 1:
				   System.out.println("Enter your username:");
				   String adminName=scr.nextLine();
				   System.out.println("Enter your password:");
				   String adminPassword=scr.nextLine();
				   try {
						app.doAdminLogin(adminName,adminPassword);
					} catch (InvalidUserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidAdminException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidBookException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				       break;
			case 2:
				   System.out.println("1. Sign In");
				   System.out.println("2. Sign Up");
				   System.out.println("Enter your choice:");
				   boolean status;
				   UserServiceImpl usi=new UserServiceImpl();
				   int ch=sc.nextInt();
				   switch(ch) {
				   case 1:
					   System.out.println("enter your userId");
					   Integer userId=sc.nextInt();
					   System.out.println("enter your password");
					   String password=scr.nextLine();
					   app.doUserLogin(userId,password);
					   break;
				   case 2:
					   System.out.println("enter userid to add user");
						int UserId=sc.nextInt();
						System.out.println("enter the userName");
						String UserName=scr.nextLine();
						System.out.println("enter the password");
						String UserPwd=scr.nextLine();
						System.out.println("enter the user Email");
						String UserEmail=scr.nextLine();
						System.out.println("enter the user Address");
						String UserAddress=scr.nextLine();
						System.out.println("enter the phonenumber");
						long UserPhone=sc.nextLong();
						boolean isEmailValid=ve1.doValidateEmail(UserEmail);
						boolean isPhoneValid=vp1.doValidatePhone(UserPhone);
						if(isEmailValid) {
							if(isPhoneValid) {
						User u=new User(UserId,UserName,UserPwd,UserEmail,UserAddress,UserPhone);
						status=usi.doAddUser(u);
						if(status) {
							System.out.println("User Registerd Successfully");
							LoginPage();
						}
						else {
							System.out.println("Sorry User Not Registered Successfully");
						}
							}
							else {
								System.out.println("Invalid Phone Number Format");
							}
						}
						else {
							System.out.println("Invalid Email Format");
						}
						
						break;
				   }
				   break;
			case 0:
				   System.out.println("\n\n Application Closed ");
				   System.exit(0);
				   break;
			default:
				break;
			}
	    }
	}
	public void doAdminLogin(String adminName,String adminPassword) throws InvalidUserException,InvalidAdminException,InvalidBookException, InvalidOrderException, InvalidCartException, ParseException
    {
		if(val.doValidateAdmin(adminName, adminPassword)) {
	while(true) {
	 System.out.println("\n****** Admin Login ******\n");
	 System.out.println("1. Manage User");
	 System.out.println("2. Manage Stock");
	 System.out.println("3. Manage Order");
	 System.out.println("0. EXIT");
	 System.out.println("Enter your choice ");
	 int ch=sc.nextInt();
	 switch(ch) {
	 case 1:
		 System.out.println("\n****** Manage Users ******\n");
		 System.out.println("1. Add user");
		 System.out.println("2. Modify User");
		 System.out.println("3. Delete User");
		 System.out.println("4. Search User");
		 System.out.println("5. Display Users By Sorting");
		 int ch1=sc.nextInt();
		 switch(ch1) {
		 case 1: // add user
				System.out.println("enter userid to add user");
				int userId=sc.nextInt();
				System.out.println("enter the userName");
				String userName=scr.nextLine();
				System.out.println("enter the password");
				String userPwd=scr.nextLine();
				System.out.println("enter the user Email");
				String userEmail=scr.nextLine();
				System.out.println("enter the user Address");
				String userAddress=scr.nextLine();
				System.out.println("enter the phonenumber");
				Long userPhone=sc.nextLong();
				boolean isEmailValid=ve.doValidateEmail(userEmail);
				boolean isPhoneValid=vp.doValidatePhone(userPhone);
				if(isEmailValid) {
					if(isPhoneValid) {
						User u=new User(userId,userName,userPwd,userEmail,userAddress,userPhone);
						status=asi.doAddUser(u);
				if(status) {
					System.out.println("-----------------------------------------");
					System.out.println("User Added Successfully");
					System.out.println("-----------------------------------------");
				}
				else {
					System.out.println("-----------------------------------------");
					System.out.println("Sorry User Not Added Successfully");
					System.out.println("-----------------------------------------");
				}
				}
					else {
						System.out.println("Invalid Phone Number Format");
					}
				}
				else {
					System.out.println("Invalid Email Format");
				}
				
				break;
		 case 2: // modify user
				System.out.println("enter userid to modify user");
				int modifyUserId=sc.nextInt();
				System.out.println("enter the userName");
				String modifyUserName=scr.nextLine();
				System.out.println("enter the password");
				String modifyUserPwd=scr.nextLine();
				System.out.println("enter the user Email");
				String modifyUserEmail=scr.nextLine();
				System.out.println("enter the user Address");
				String modifyUserAddress=scr.nextLine();
				System.out.println("enter the phonenumber");
				Long modifyUserPhone=sc.nextLong();
				isEmailValid=ve.doValidateEmail(modifyUserEmail);
				isPhoneValid=vp.doValidatePhone(modifyUserPhone);
				if(isEmailValid) {
					if(isPhoneValid) {
				User us=new User(modifyUserId,modifyUserName,modifyUserPwd,modifyUserEmail,modifyUserAddress,modifyUserPhone);
				status=asi.doModifyUser(us);
				if(status) {
					System.out.println("-----------------------------------------");
					System.out.println("User Modified Successfully");
					System.out.println("-----------------------------------------");
				}
				else {
					System.out.println("-----------------------------------------");
					System.out.println("User Not Found!");
					System.out.println("Sorry User Not Modified Successfully");
					System.out.println("-----------------------------------------");
				}
					}
					else {
						System.out.println("Invalid Phone Number Format");
					}
				}
				else {
					System.out.println("Invalid Email Format");
				}
				break;
		 case 3: // delete user
				System.out.println("enter the userId to Delete");
				int delUserId=sc.nextInt();
				status=asi.doDeleteUser(delUserId);
				if(status) {
					System.out.println("-----------------------------------------");
					System.out.println("User Deleted Successfully");
					System.out.println("-----------------------------------------");
				}
				else {
					System.out.println("-----------------------------------------");
					System.out.println("User Not Found!");
					System.out.println("Sorry User Not Deleted Successfully");
					System.out.println("-----------------------------------------");
				}
				break;
		 case 4: //search user
			 System.out.println("1. Search by UserId");
			 System.out.println("2. Search by UserName");
			 System.out.println("Enter your choice ");
			 int ch2=sc.nextInt();
			 switch(ch2) {
			 case 1:
				 System.out.println("Enter the UserId to search");
					int userID=sc.nextInt();
					status1=asi.doSearchUser(userID);
					if(status1!=null) {
						go.PrintUserDetaisOfSearch(status1);
					}
					else {
						System.out.println("-----------------------------------------");
						System.out.println("Sorry User Not Found");
						System.out.println("-----------------------------------------");
					}
					break;
			 case 2://search user by username
				    System.out.println("enter the userName");
				    String searchUserName=scr.next();
				    User status3 = asi.doSearchUser(searchUserName);
				    if(status3!=null) {
				    	go.PrintUserDetaisOfSearch(status3);
				    }
				    else
				    {
				    	System.out.println("-----------------------------------------");
				    	System.out.println("Sorry User Not Found");
				    	System.out.println("-----------------------------------------");
				    }
				   break;
			 default:
					break;
			 }
			 
			break;
		 case 5:
			 System.out.println("1. Display Users By UserId");
			 System.out.println("2. Display Users By UserName");
			 System.out.println("3. Display Users By Range");
			 System.out.println("Enter your Choice:");
			 int ch5=sc.nextInt();
			 switch(ch5) {
			 
			 case 1:
				 List<User> users1=asi.getUsers();
				 System.out.println("Sorted by userId");
				    SortByUserId userIdCompare = new SortByUserId();
				    Collections.sort(users1, userIdCompare);
					
				 go.PrintUserDetaisOfSort(users1);
					break;
			 case 2:
				 List<User> users2=asi.getUsers();
				 System.out.println("Sorted by userName");
				    SortByUserName userNameCompare = new SortByUserName();
				    Collections.sort(users2, userNameCompare);
				 go.PrintUserDetaisOfSort(users2);
				 break;
	
			 case 3:
				 System.out.println("enter the userId1");
					int userId1=sc.nextInt();
					System.out.println("enter the userId2");
					int userId2=sc.nextInt();
					List<User> users=asi.getUsersByRange(userId1,userId2);
					go.PrintUserDetaisOfSort(users);
					break;
			 }
				
			 
		 default:
				break;
		 }
		 break;
	 case 2:
		 System.out.println("\n****** Manage Stock ******\n");
		 System.out.println("1. Add Books ");
		 System.out.println("2. Edit Books ");
		 System.out.println("3. Delete Books ");
		 System.out.println("4. Search Book");
		 System.out.println("5. Display Books By Sorting");
		 System.out.println("Enter your choice ");
		 int ch2=sc.nextInt();
		 switch(ch2) {
		 case 1: //add books
				System.out.println("enter inter national standard book number");
				int isbn=sc.nextInt();
				System.out.println("enter book title");
				String title=scr.nextLine();
				System.out.println("enter book author");
				String author=scr.nextLine();
				System.out.println("enter book price");
				int price=sc.nextInt();	
				System.out.println("enter quantity");
				int qty=sc.nextInt();
			    Book b =new Book(isbn,title,author,price,qty);
				status=asi.doAddBooks(b);
				if(status) {
					System.out.println("-----------------------------------------");
					System.out.println("Book Added Successfully");
					System.out.println("-----------------------------------------");
				}
				else {
					System.out.println("-----------------------------------------");
					System.out.println("Sorry Book Not Added Successfully");
					System.out.println("-----------------------------------------");
				}
				 break;
		
		 case 2://edit books
				System.out.println("Enter Inter National Standard Book Number(Isbn)");
				int modifyIsbn=sc.nextInt();
				System.out.println("enter book title");
				String modifyTitle=scr.nextLine();
				System.out.println("enter book author");
				String modifyAuthor=scr.nextLine();
				System.out.println("enter book price");
				int modifyPrice=sc.nextInt();
				System.out.println("enter quantity");
				int modifyQty=sc.nextInt();
				 Book bk =new Book(modifyIsbn,modifyTitle,modifyAuthor,modifyPrice,modifyQty);
				 status=asi.doEditBooks(bk);
				 if(status) {
					 System.out.println("-----------------------------------------");
						System.out.println("Book Modified Successfully");
						System.out.println("-----------------------------------------");
					}
					else {
						System.out.println("-----------------------------------------");
						System.out.println("Sorry Book Not Modified Successfully");
						System.out.println("-----------------------------------------");
					}
				 break;
		  case 3: // delete Books
				System.out.println("Enter book Isbn number");
				int bookIsbn=sc.nextInt();
				status=asi.doDeleteBooks(bookIsbn);
				if(status) {
					System.out.println("-----------------------------------------");
					System.out.println("Book Deleted Successfully");
					System.out.println("-----------------------------------------");
				}
				else {
					System.out.println("-----------------------------------------");
					System.out.println("Sorry Book Not Deleted Successfully");
					System.out.println("-----------------------------------------");
				}
				break;
		 case 4: //search Book
			 System.out.println("1. Search Book By ISBN");
			 System.out.println("2. Search Book By Author");
			 System.out.println("3. Search Book By Title");
			 System.out.println("Enter your choice ");
			 int ch3=sc.nextInt();
			 switch(ch3) {
			 case 1:
				 System.out.println("Enter the Book ISBN to search:");
					int Isbn=sc.nextInt();
					status2=asi.doSearchBook(Isbn);
					if(status2!=null) {
						go.PrintBookDetaisOfSearch(status2);
					}
					else {
						System.out.println("-----------------------------------------");
						System.out.println("Sorry Book Not Found");
						System.out.println("-----------------------------------------");
					}
					break;
			 case 2://search by author name
					System.out.println("enter the author name");
					String authorSearch=scr.next();
					status2=asi.doSearchBook(authorSearch);
					if(status2!=null) {
						go.PrintBookDetaisOfSearch(status2);
					}
					else {
						System.out.println("-----------------------------------------");
						System.out.println("Sorry Book Not Found");
						System.out.println("-----------------------------------------");
					}
					break;
			 case 3:
				   System.out.println("enter the book title");
				   String titleSearch=scr.nextLine();
				   status2=asi.searchByBookTitle(titleSearch);
				   if(status2!=null) {
					   go.PrintBookDetaisOfSearch(status2);
					}
					else {
						System.out.println("-----------------------------------------");
						System.out.println("Sorry Book Not Found");
						System.out.println("-----------------------------------------");
					}
					break;
			 default:
					break;
			 }
			 break;
		 case 5: //Get Books By Sorting
			 System.out.println("1. Display Books By Isbn");
			 System.out.println("2. Display Books By Title");
			 System.out.println("3. Display Books By Author");
			 System.out.println("4. Display Books By Price");
			 System.out.println("5. Display Books By Quantity");
			 System.out.println("Enter your Choice:");
			 int ch4=sc.nextInt();
			 List<Book> books=asi.getBooks();
			 switch(ch4) {
			 case 1:
				 
				 System.out.println("Displaying Books by Isbn");
				 SortByBookIsbn IsbnCompare = new SortByBookIsbn();
				 Collections.sort(books, IsbnCompare);
				 go.PrintBookDetaisOfSort(books);
					break;
			 case 2:
				 System.out.println("Displaying Books by Title");
				 SortByBookTitle TitleCompare = new SortByBookTitle();
				 Collections.sort(books, TitleCompare);
				 go.PrintBookDetaisOfSort(books);
					break;
			 case 3:
				 System.out.println("Displaying Books by Author");
				 SortByBookAuthor AuthorCompare = new SortByBookAuthor();
				 Collections.sort(books, AuthorCompare);
				 go.PrintBookDetaisOfSort(books);
					break;
			 case 4:
				 System.out.println("Displaying Books by Price");
				    SortByBookPrice priceCompare = new SortByBookPrice();
				    Collections.sort(books, priceCompare);
				 go.PrintBookDetaisOfSort(books);
					break;
			 case 5:
				 System.out.println("Displaying Books by Quantity");
				    SortByBookQuantity qtyCompare = new SortByBookQuantity();
				    Collections.sort(books, qtyCompare);
				 go.PrintBookDetaisOfSort(books);
					break;
			 
			 default:
					break;
			 }
			 
				
		 default:
				break;
		 }
		 break;
	 case 3: //Display Orders By Sorting
		 System.out.println("\n****** Manage Orders ******\n");
		 System.out.println("1. Display Orders by Sorting");
		 System.out.println("2. Search Orders");
		 System.out.println("Enter your Choice:");
		 int ch3=sc.nextInt();
		 switch(ch3) {
		 case 1:
			 System.out.println("1. Display Orders by UserID");
			 System.out.println("2. Display Orders by OrderID");
			 System.out.println("3. Display Orders by OrderDate");
			 int ch4=sc.nextInt();
			 List<Order> orders=asi.getOrders();
			 switch(ch4) {
			 case 1:
				 System.out.println("Displaying Orders by UserId");
				    SortOrderByUserId userIdCompare = new SortOrderByUserId();
				    Collections.sort(orders, userIdCompare);
				 go.PrintOrderDetaisOfSort(orders);
					break;
			 case 2:
				 System.out.println("Displaying Order by OrderId");
				    SortByOrderId orderIdCompare = new SortByOrderId();
				    Collections.sort(orders, orderIdCompare);
				 go.PrintOrderDetaisOfSort(orders);
					break;
		
			 case 3:
				 System.out.println("Displaying Order by OrderDate");
				    SortByOrderDate orderDateCompare = new SortByOrderDate();
				    Collections.sort(orders, orderDateCompare);
				 go.PrintOrderDetaisOfSort(orders);
					break;
			 default:
					break;
		 
		 }
		 break;
		 case 2: //Search Orders
			 System.out.println("1. Search Order BY UserId");
			 System.out.println("2. Search Order BY OrderId");
			 System.out.println("3. Search Order BY OrderDate");
			 int ch6=sc.nextInt();
			 switch(ch6) {
			 case 1://search Order by userId
				    System.out.println("enter the userId");
				    int SearchUserId=sc.nextInt();
				    List<Order> UserIdStatus = asi.doSearchOrderByUserId(SearchUserId);
				    if(UserIdStatus.size()>0) {
				    	go.PrintOrderDetaisOfSort(UserIdStatus);
				    }
						
				    else
				    {
				    	System.out.println("-----------------------------------------");
				    	System.out.println("Order not found");
				    	System.out.println("-----------------------------------------");
				    }
				   break;
			 case 2://search Order by OrderId
				    System.out.println("enter the OrderId");
				    int SearchOrderId=sc.nextInt();
				    List<Order> OrderIdStatus = asi.doSearchOrderByOrderId(SearchOrderId);
				    if(OrderIdStatus.size()>0) {
				    	go.PrintOrderDetaisOfSort(OrderIdStatus);
				    }
						
				    else
				    {
				    	System.out.println("-----------------------------------------");
				    	System.out.println("Order not found");
				    	System.out.println("-----------------------------------------");
				    }
				   break;
			 case 3://search Order by OrderDate
				    System.out.println("enter the Order Date(DD/MM/YYYY)");
				    String OrderDate=scr.nextLine();
				    List<Order> OrderStatus2 = asi.doSearchOrderByOrderDate(OrderDate);
				    if(OrderStatus2.size()>0) {
				    	go.PrintOrderDetaisOfSort(OrderStatus2);
				    }
						
				    else
				    {
				    	System.out.println("-----------------------------------------");
				    	System.out.println("Order not found");
				    	System.out.println("-----------------------------------------");
				    }
				   break;
			 default:
					break;
			 }
		 }
		 break;
	case 0:
		   System.out.println("-----------------------------------------");
		   System.out.println("\n\n Logged Out ");
		   System.out.println("-----------------------------------------");
		   LoginPage();
		   System.exit(0);
		   
		   break;
	 
	default:
		break;
	
	 }
}
	}
		else {
			System.out.println("-----------------------------------------");
			System.out.println("UserName or Password Invalid");
			System.out.println("-----------------------------------------");
			System.out.println("Enter your username");
			   adminName=scr.nextLine();
			   System.out.println("Enter your password");
			   adminPassword=scr.nextLine();
			   doAdminLogin(adminName,adminPassword);
			
		}
    	
    }
	
	public void doUserLogin(int userId,String password) throws InvalidBookException, InvalidOrderException, InvalidUserException, InvalidAdminException, InvalidCartException, ParseException
	 {
		 boolean status=vul.doValidateUser(userId, password);
		 if(status) {
			 while(true) {
			 System.out.println("\n****** User Login ******\n");
			 System.out.println("1. Display Books");
			 System.out.println("2. Search Books");
			 System.out.println("3. Add Books to Cart");
			 System.out.println("4. View Cart");
			 System.out.println("5. Order Book");
			 System.out.println("6. View Order");
			 System.out.println("7. Empty Cart");
			 System.out.println("8. Cancel Order");
			 System.out.println("0. Logout");
			 System.out.println("Enter your Choice");
			 int ch=sc.nextInt();
			 switch(ch) {
			 case 1: //Get Books By Sorting
				 System.out.println("1. Display Books By Isbn");
				 System.out.println("2. Display Books By Title");
				 System.out.println("3. Display Books By Author");
				 System.out.println("4. Display Books By Price");
				 System.out.println("5. Display Books By Quantity");
				 System.out.println("Enter your Choice:");
				 int ch4=sc.nextInt();
				 List<Book> books=asi.getBooks();
				 switch(ch4) {
				 case 1:
					 
					 System.out.println("Displaying Books by Isbn");
					 SortByBookIsbn IsbnCompare = new SortByBookIsbn();
					 Collections.sort(books, IsbnCompare);
					 go.PrintBookDetaisOfSort(books);
						break;
				 case 2:
					 System.out.println("Displaying Books by Title");
					 SortByBookTitle TitleCompare = new SortByBookTitle();
					 Collections.sort(books, TitleCompare);
					 go.PrintBookDetaisOfSort(books);
						break;
				 case 3:
					 System.out.println("Displaying Books by Author");
					 SortByBookAuthor AuthorCompare = new SortByBookAuthor();
					 Collections.sort(books, AuthorCompare);
					 go.PrintBookDetaisOfSort(books);
						break;
				 case 4:
					 System.out.println("Displaying Books by Price");
					    SortByBookPrice priceCompare = new SortByBookPrice();
					    Collections.sort(books, priceCompare);
					 go.PrintBookDetaisOfSort(books);
						break;
				 case 5:
					 System.out.println("Displaying Books by Quantity");
					    SortByBookQuantity qtyCompare = new SortByBookQuantity();
					    Collections.sort(books, qtyCompare);
					 go.PrintBookDetaisOfSort(books);
						break;
				 
				 default:
						break;
				 }
				 break;
			 case 2: //search Books
				 System.out.println("1. Search By ISBN");
				 System.out.println("2. Search By Author");
				 System.out.println("3. Search By Title");
				 System.out.println("Enter your choice ");
				 int ch3=sc.nextInt();
				 switch(ch3) {
				 case 1:
					 System.out.println("Enter the Book ISBN to search");
						int Isbn=sc.nextInt();
						status2=usi.doSearchBook(Isbn);
						if(status2!=null) {
							go.PrintBookDetaisOfSearch(status2);
						}
						else {
							System.out.println("-----------------------------------------");
							System.out.println("Sorry Book Not Found");
							System.out.println("-----------------------------------------");
						}
						break;
				 case 2://search by author name
						System.out.println("enter the author name");
						String authorSearch=scr.next();
						status2=usi.doSearchBook(authorSearch);
						if(status2!=null) {
							go.PrintBookDetaisOfSearch(status2);
						}
						else {
							System.out.println("-----------------------------------------");
							System.out.println("Sorry Book Not Found");
							System.out.println("-----------------------------------------");
						}
						break;
				 case 3:
					   System.out.println("enter the book title");
					   String titleSearch=scr.nextLine();
					   status2=usi.searchByBookTitle(titleSearch);
					   if(status2!=null) {
						   go.PrintBookDetaisOfSearch(status2);
						}
						else {
							System.out.println("-----------------------------------------");
							System.out.println("Sorry Book Not Found");
							System.out.println("-----------------------------------------");
						}
						break;
				 default:
						break;
				 }
				 break;
			 case 3: //Cart Book
				 System.out.println("Enter BookIsbn:");
				 int BookIsbn=sc.nextInt();
				 System.out.println("Enter BookTitle:");
				 String BookTitle=scr.nextLine();
				 System.out.println("Enter BookQuantity:");
				 int BookQty=sc.nextInt();
				 int TotalPrice=usi.doCalculateTotalPrice(BookIsbn, BookQty);
				 int TotalBooks=usi.getTotalBooks(BookIsbn);
				 if(TotalBooks>BookQty) {
					 Cart crt=new Cart(userId,BookIsbn,BookTitle,BookQty,TotalPrice);
					 status=usi.doCartBooks(crt);
					 if(status) {
						 System.out.println("-----------------------------------------");
							System.out.println("Book Added to Cart Successfully");
							System.out.println("Total Amount of the Order is: "+TotalPrice);
							System.out.println("You can Order the carted books in \"Order Book\"");
							System.out.println("-----------------------------------------");
						}
						else {
							System.out.println("-----------------------------------------");
							System.out.println("Sorry Book Not Added to Cart Successfully");
							System.out.println("-----------------------------------------");
						}
				 }
				 else {
					 System.out.println("-----------------------------------------");
					 System.out.println("Insufficient Book OR Enter valid Isbn");
					 System.out.println("Only "+TotalBooks+" available in the Store");
					 System.out.println("-----------------------------------------");
				 }
				 
				 break;
			 case 4: //View Cart
				 
						List<Cart> CartOrders=usi.DisplayCartOrders(userId);
						int TotalOrderAmount=usi.doCalculateTotalOrderPrice(userId);
						if(CartOrders.size()>0) {
							go.PrintCartDetais(CartOrders,TotalOrderAmount);
						}
						else {
							System.out.println("-----------------------------------------");
							System.out.println("Cart is Empty");
							System.out.println("-----------------------------------------");
						}
					break;
			 case 5: //Order Book
				 
				 int orderID=0;
				 Integer OrderID=usi.GetOrderId();
				 if(OrderID>1) {
					 orderID=OrderID+1;
				 }
				 else {
					 orderID=301;
				 }
				 
				 Date CurrentDate=usi.GetCurrentDate();
				 Time CurrentTime=usi.GetCurrentTime();
				 int TotalOrderAmount1=usi.doCalculateTotalOrderPrice(userId);
				 List<Cart> CartOrders1=usi.DisplayCartOrders(userId);
				 if(CartOrders1.size()>0) {
					 go.PrintCartDetais(CartOrders1,TotalOrderAmount1);
					for (Cart ct : CartOrders1) 
					{
						Order ord=new Order(ct.getUserId(),ct.getBookIsbn(),ct.getBookTitle(),ct.getBookQuantity(),ct.getTotalPrice(),orderID,CurrentDate,CurrentTime);
						Orderstatus=usi.doOrderBooks(ord);
						int TotalBooks1=usi.getTotalBooks(ct.getBookIsbn());
						int UpdatedTotalBooks=TotalBooks1-ct.getBookQuantity();
						usi.doUpdateBooksTotal(UpdatedTotalBooks,ct.getBookIsbn());
						
					}					
					    if(Orderstatus) {
						System.out.println("Book Ordered Successfully");
						System.out.println("You can View Order Details in \"View Order\"");
						usi.doEmptyCart(userId);
					    }
					    else {
					    	System.out.println("-----------------------------------------");
					    	System.out.println("Sorry Book Not Ordered Successfully");
					    	System.out.println("-----------------------------------------");
					    }
					}
					else {
						System.out.println("-----------------------------------------");
						System.out.println("Cart is Empty!\nPlease add Books to the Cart");
						System.out.println("-----------------------------------------");
					}	
				 break;
			 case 6: //View Orders
						List<Order> orders=usi.viewOrdersByUseId(userId);
						if(orders.size()>0) {
							go.PrintOrderDetaisOfSearch(orders);
						}
						else {
							System.out.println("No Orders to Display");
						}
					break;
			 case 7: // Empty Cart
					status=usi.doEmptyCart(userId);
					if(status) {
						System.out.println("-----------------------------------------");
						System.out.println("Cart Empty Successfully");
						System.out.println("-----------------------------------------");
					}
					else {
						System.out.println("-----------------------------------------");
						System.out.println("Sorry Cart Empty Not Successfully\nCart is already Empty!");
						System.out.println("-----------------------------------------");
					}
				 break;
			 case 8: //Cancel Order
				    System.out.println("enter the orderId to Cancel Order");
				    int orderId=sc.nextInt();
				    List<Order> CanceledOrders=usi.getCanceledOrders(userId, orderId);
					Integer TotalRefundAmount=usi.doCalculateTotalCancelOrderPrice(userId,orderId);
					
				    List<Integer> getOrderIsbn=usi.getOrderIsbn(userId, orderId);
						for(Integer OI:getOrderIsbn) {
						int TotalBooks1=usi.getTotalBooks(OI);
						int OrderQty=usi.getOrderQty(userId,orderId,OI);
						int UpdateBookTotal=TotalBooks1+OrderQty;
						usi.doUpdateBooksTotal(UpdateBookTotal,OI);
					}
					go.PrintCanceledOrderDetais(CanceledOrders,TotalRefundAmount);
					status=usi.doCancelOrder(userId,orderId);
					if(status) {
						System.out.println("-----------------------------------------");
						System.out.println("Order Canceled Successfully");
						System.out.println("-----------------------------------------");
					}
					else {
						System.out.println("-----------------------------------------");
						System.out.println("Sorry Order Not Cancelled Successfully");
						System.out.println("Please Enter Valid OrderID!");
						System.out.println("-----------------------------------------");
					}
					break;
			 case 0:
				 System.out.println("-----------------------------------------");
				 System.out.println("\n\n Logged Out ");
				 System.out.println("-----------------------------------------");
				 LoginPage();
				  System.exit(0);
				 break;
			 default:
					break;
			 }
			 }
		 }
		 else {
			 System.out.println("-----------------------------------------");
			 System.out.println("UserId or Password Invalid");
			 System.out.println("-----------------------------------------");
				System.out.println("Enter your userId");
				   int UserId=sc.nextInt();
				   System.out.println("enter your password");
				   String UserPassword=scr.nextLine();
				   doUserLogin(UserId,UserPassword);
		 }
	}
}