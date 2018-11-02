package com.verizon.bsa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.verizon.bsa.model.Book;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		
		book.setEid(rs.getInt(1));
		book.setName(rs.getString(2));
		book.setBasic(rs.getDouble(3));
		book.setHra(rs.getDouble(4));
		book.setDept(rs.getString(5));
		
		return book;
	}

}
