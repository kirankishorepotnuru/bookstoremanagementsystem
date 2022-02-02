package com.capg.BookStoreManagement.services;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.dao.AdminDAO;
import com.capg.BookStoreManagement.dao.AdminDAOImpl;

public class AdminServiceImplTest {
	public AdminDAO ad;
	
	@Before
	public void init()
	{
		ad=new AdminDAOImpl();
	}
	
	
	@Test
	public void testDoSearchBook() {
		int Isbn=123456789;
		Book expectedOutput= new Book(123456789,"Mathematics","Thomas",1800,193);
		Book actualOutput=ad.doSearchBook(Isbn);
		assertEquals(expectedOutput, actualOutput);
		
	}

	@Test
	public void testDoSearchBookByTitle()
	{
		String title="Computer Science";
		Book expectedOutput=new Book(456789321,"Computer Science","Johnson",2500,153);
		Book actualOutput=ad.searchByBookTitle(title);
		Assert.assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testDoSearchBookAuthor()
	{
		String author="Thomas";
		Book expectedOutput=new Book(123456789,"Mathematics","Thomas",1800,193);
		Book actualOutput=ad.doSearchBook(author);
		Assert.assertEquals(expectedOutput, actualOutput);
	}
	
	
}