package com.verizon.bsa.dao;

public interface IQueryMapper {
	
	public static final String INS_BOOK_QRY =
			"INSERT INTO books VALUES(?,?,?,?,?)";
	public static final String DEL_BOOK_QRY =
			"DELETE FROM books WHERE eid=?";
	public static final String UPDATE_BOOK_QRY =
			"UPDATE books SET name=?,basic=?,hra=?,dept=? WHERE eid=?";
	public static final String GET_BOOK_QRY =
			"SELECT * FROM books WHERE eid=?";
	public static final String GET_ALL_BOOKS_QRY =
			"SELECT * FROM books";

}
