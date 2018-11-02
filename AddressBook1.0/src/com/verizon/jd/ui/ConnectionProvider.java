package com.verizon.jd.ui;



import java.sql.*;


public class ConnectionProvider {
		private String driverName;
		private String dbUrl;
		private String dbUserName;
		private String dbPassword;
		
		private static ConnectionProvider instance;
		
		public ConnectionProvider() throws ClassNotFoundException{
			driverName = "com.mysql.jdbc.Driver";
			dbUrl = "jdbc:mysql://localhost:3306/adb";
			dbUserName= "root";
			dbPassword = "password";
			
			Class.forName(driverName);
		}
		public static ConnectionProvider getInstance() throws ClassNotFoundException{
			if(instance == null)
				instance = new ConnectionProvider();
			return instance;
		}
		
		public Connection getConnection() throws SQLException{
			
				return DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			
		}
		
		public String getDriverName() {
			return driverName;
		}
		public void setDriverName(String driverName) {
			this.driverName = driverName;
		}
		public String getDbUrl() {
			return dbUrl;
		}
		public void setDbUrl(String dbUrl) {
			this.dbUrl = dbUrl;
		}
		public String getDbUserName() {
			return dbUserName;
		}
		public void setDbUserName(String dbUserName) {
			this.dbUserName = dbUserName;
		}
		public String getDbPassword() {
			return dbPassword;
		}
		public void setDbPassword(String dbPassword) {
			this.dbPassword = dbPassword;
		}
		

	}



