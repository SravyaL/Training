package com.verizon.subswing.dao;

public interface QueryMapper {
	
	public static final String INS_CONT_QRY =
			"INSERT INTO Subjects VALUES(?,?,?)";
	
	public static final String DEL_CONT_QRY =
			"DELETE FROM Subjects WHERE id=?";
	
	public static final String SET_ALL_CONT_QRY = 
			"SELECT * FROM Subjects";
	
	public static final String SEL_CONT_BY_MNO_QRY = 
			"SELECT * FROM Subjects WHERE id=?";
	
}


