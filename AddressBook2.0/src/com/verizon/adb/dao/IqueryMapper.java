package com.verizon.adb.dao;

public interface IqueryMapper {

	public static final String INS_CONT_QRY = "INSERT INTO Contacts VALUES(?,?,?)";
	public static final String DEL_CONT_QRY = "DELETE FROM Contacts WHERE mobile=?";
	public static final String UPD_CONT_QRY = "UPDATE Contacts SET cname=?,mailid=? WHERE mobile=?";
	public static final String SEL_ALL_CONT_QRY = "SELECT* FROM Contacts";
	public static final String SEL_CONT_BY_CONT_QRY = "SELECT * FROM Contacts WHERE mobile=?";

}
