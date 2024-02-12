package com.chapter16;

import java.sql.DriverManager;
import java.sql.Statement;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

class CreateTable {
	
	public static void main(String[] args) {
		final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
		final String CONNECTION = "jdbc:derby:MeizinDatabase;create=true";
		try {
			//Class<?> driverClass = Class.forName(DRIVER);
			//Object driverInstance = driverClass.getDeclaredConstructor().newInstance();
			Class.forName(DRIVER).getDeclaredConstructor().newInstance();
		 } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException e) {
			 e.printStackTrace();
		 } catch (InvocationTargetException e) {
			 e.printStackTrace();
		 } 
		
		try (Connection connection = 
				DriverManager.getConnection(CONNECTION); 
				Statement statement = connection.createStatement()) {
			/*
			   statement.executeUpdate(
			     "create table ACCOUNTS                       "
			   + "  (NAME VARCHAR(32) NOT NULL PRIMARY KEY,   "
			   + "   ADDRESS VARCHAR(32),                     "
			   + "   BALANCE FLOAT)                       ");
			
			statement.executeUpdate(
				 "insert into ACCOUNTS values                 "
			   + "  ('Барри Берд', 'улица Киберов, 230', 24.04)");
			
			statement.executeUpdate(
			     "insert into ACCOUNTS values                 "
			   + "  ('Дмитрий Мэйдзин', 'улица Нарочанская, 30', 21.09)");
			   
			statement.executeUpdate(
					 "insert into ACCOUNTS values                 "
				   + "  ('Дитер Бохлен', 'улица Киберштрассе, 230', 24.04)");
			
			statement.executeUpdate(
					 "insert into ACCOUNTS values                 "
				   + "  ('Томас Андерс', 'улица Киберштрассе, 230', 24.04)");
			*/
			statement.executeUpdate(
					 "insert into ACCOUNTS values                 "
				   + "  ('C.C. Catch', 'улица Киберштрассе, 237', 24.04)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
