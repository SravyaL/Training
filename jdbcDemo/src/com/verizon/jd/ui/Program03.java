package com.verizon.jd.ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class Program03 {

	public static void main(String[] args) {
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				PreparedStatement pst = con.prepareStatement("SELECT * FROM Book")){
			//Statement stmt = con.createStatement();
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				System.out.println(
						rs.getInt(1)+"\t"+
						rs.getString(2) + "\t"+
						rs.getDouble(3)
						);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
