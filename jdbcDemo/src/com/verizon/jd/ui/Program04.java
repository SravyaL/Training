package com.verizon.jd.ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class Program04 {
	public static void main(String[] args) {

		try (Connection con = ConnectionProvider.getInstance().getConnection();
				PreparedStatement pst = con.prepareStatement("INSERT INTO Book VALUES(?,?,?)");
				Scanner scan = new Scanner(System.in);
				) {
			// Statement stmt = con.createStatement();
			System.out.println("Bcode: ");
			int bcode = scan.nextInt();
			System.out.println("Title: ");
			String bnm = scan.next();
			System.out.println("Price: ");
			double price = scan.nextDouble();
			pst.setInt(1, bcode);
			pst.setString(2, bnm);
			pst.setDouble(3, price);
			int count = pst.executeUpdate();
			System.out.println(count+" row(s) inserted!");

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
