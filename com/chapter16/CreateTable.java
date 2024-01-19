package com.chapter16;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

class CreateTable {
	
	public static void main(String[] args) {
		final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
		final String CONNECTION = "jdbc:derby:AccountDatabase;
		                           create=true";
		try {
			Class.forName(DRIVER).newInstance();
		 } catch (InstantionException e) {
			 e.printStackTrace();
		 } catch (IllegalAccessException e) {
			 e.printStackTrace();
		 } catch (ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		
		try (Connection connection = 
				DriveManager.getConnection(CONNECTION); 
				Statement statement = connection.createStatement()) {
			statement.executeUpdate(
			     "create table ACCOUNTS                       "
			   + "  (NAME VARCHAR(32) NOT NULL PRIMARY KEY,   "
			   + "   ADDRESS VARCHAR(32),                     "
			   + "   BALANCE FLOAT)                       ");
			statement.executeUpdate(
				 "insert into ACCOUNTS values                 "
			   + "  ('Барри Берд', 'улица Киберов, 234', 24.04)");
			
			statement.executeUpdate(
			     "insert into ACCOUNTS values                 "
			   + "  ('Дмитрий Мэйдзин', 'улица Нарочанская, 37', 21.09)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
