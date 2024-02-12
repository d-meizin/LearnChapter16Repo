package com.chapter16;

import static java.lang.System.out;

import java.lang.reflect.InvocationTargetException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.NumberFormat;
class GetData {

	public static void main(String[] args) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
		final String CONNECTION = "jdbc:derby:MeizinDatabase;create=true";
		
		try {
			//Class.forName(DRIVER).newInstance();
			Class.forName(DRIVER).getDeclaredConstructor().newInstance();
				
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		try (Connection connection = 
			DriverManager.getConnection(CONNECTION);
			Statement statement = connection.createStatement();
			ResultSet resultset = 
				statement.executeQuery("select * from ACCOUNTS")) {
			while(resultset.next()) {
				out.print(resultset.getString("NAME"));
				out.print(", ");
				out.print(resultset.getString("ADDRESS"));
				out.print(" ");
				out.println(currency.format(resultset.
						getFloat("BALANCE")));
				out.println("* * * * * * *");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
