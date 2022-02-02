package com.capg.BookStoreManagement.beans;

public class Book implements Comparable<Book>{
	private int  isbn;
	private String title;
	private String author;
	private int price;
	private int qty;

	public Book(int isbn,String title,String author,int price,int qty) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getQty() {
		return qty;
	}
public int compareTo(Book b) {
		return this.isbn-b.isbn;
		}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((author == null) ? 0 : author.hashCode());
	result = prime * result + isbn;
	result = prime * result + price;
	result = prime * result + qty;
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Book other = (Book) obj;
	if (author == null) {
		if (other.author != null)
			return false;
	} else if (!author.equals(other.author))
		return false;
	if (isbn != other.isbn)
		return false;
	if (price != other.price)
		return false;
	if (qty != other.qty)
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}



}