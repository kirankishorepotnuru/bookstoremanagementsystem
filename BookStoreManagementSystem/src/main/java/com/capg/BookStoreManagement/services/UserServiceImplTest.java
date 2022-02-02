package com.capg.BookStoreManagement.services;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.dao.UserDAO;
import com.capg.BookStoreManagement.dao.UserDAOImpl;

public class UserServiceImplTest {
	public UserDAO ud;
	
	@Before
	public void init()
	{
		ud=new UserDAOImpl();
	}
	
	@Test
	public void testDoSearchBook() {
		int Isbn=123456789;
		Book expectedOutput= new Book(123456789,"Mathematics","Thomas",1800,193);
		Book actualOutput=ud.doSearchBook(Isbn);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testDoSearchBookByTitle()
	{
		String title="Computer Science";
		Book expectedOutput=new Book(456789321,"Computer Science","Johnson",2500,153);
		Book actualOutput=ud.searchByBookTitle(title);
		Assert.assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testDoSearchBookAuthor()
	{
		String author="Thomas";
		Book expectedOutput=new Book(123456789,"Mathematics","Thomas",1800,193);
		Book actualOutput=ud.doSearchBook(author);
		Assert.assertEquals(expectedOutput, actualOutput);
	}
}