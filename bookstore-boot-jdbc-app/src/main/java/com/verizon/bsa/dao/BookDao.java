package com.verizon.bsa.dao;

import java.util.List;

import com.verizon.bsa.model.Book;

public interface BookDao {

	Book addBook(Book book);
	Book updateBook(Book book);
	Book getBookById(int eid);
	boolean deleteBookById(int eid);
	List<Book> getAllBooks();
	
}
