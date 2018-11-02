package com.verizon.bsa.service;

import java.util.List;

import com.verizon.bsa.model.Book;

public interface BookService {
	Book addBook(Book book);
	Book updateBook(Book book);
	Book getBookById(int eid);
	boolean deleteBookById(int eid);
	List<Book> getAllBooks();
}
