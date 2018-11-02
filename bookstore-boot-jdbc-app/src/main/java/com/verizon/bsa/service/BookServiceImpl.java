package com.verizon.bsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.verizon.bsa.dao.BookDao;
import com.verizon.bsa.model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
	//@CachePut(value="books",key="#book.eid")
	@Override
	public Book addBook(Book book) {
		return bookDao.addBook(book);
	}
	
	//@CachePut(value="books",key="#book.eid")
	@Override
	public Book updateBook(Book book) {
		return bookDao.updateBook(book);
	}
	//@Cacheable(value="books",key="#eid")
	@Override
	public Book getBookById(int eid) {
		return bookDao.getBookById(eid);
	}
	//@CacheEvict(value="books",key="#eid")
	@Override
	public boolean deleteBookById(int eid) {
		return bookDao.deleteBookById(eid);
	}
	//@Cacheable("books")
	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

}
