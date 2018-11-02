package com.verizon.jd.ui;

import java.sql.*;

public class Program02 {

	public static void main(String[] args) {
		try(Connection con = ConnectionProvider.getInstance().getConnection()){
			System.out.println("Connection Established!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
