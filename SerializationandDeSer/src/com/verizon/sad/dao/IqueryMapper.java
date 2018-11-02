package com.verizon.sad.dao;


	public interface IqueryMapper {

		public static final String INS_CONT_QRY = "INSERT INTO Subjects VALUES(?,?,?)";
		public static final String DEL_CONT_QRY = "DELETE FROM Subjects WHERE id=?";
		public static final String SEL_ALL_CONT_QRY = "SELECT* FROM Subjects";
		public static final String SEL_CONT_BY_CONT_QRY = "SELECT * FROM Subjects WHERE id=?";
		
		public static final String SEL_BY_ID = "SELECT * FROM Subjects ORDER BY id";
		public static final String SEL_BY_TITLE = "SELECT * FROM Subjects ORDER BY title";

		public static final String SEL_BY_DURATION = "SELECT * FROM Subjects ORDER BY duration";



	}


