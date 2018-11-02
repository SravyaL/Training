package com.verizon.jd.ui;

import java.sql.*;

//import com.mysql.jdbc.Connection;

public class Program01 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbUrl = "jdbc:mysql://localhost:3306/adb";
			String uid = "root";
			String pwd = "password";
			
			try {
				Connection con =  DriverManager.getConnection(dbUrl, uid, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Database connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
