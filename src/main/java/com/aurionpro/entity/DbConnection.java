package com.aurionpro.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {

	private static Connection connection=null;
	private PreparedStatement preparedStatement;

	private DbConnection() {

	}


	public static Connection connect() {
		try {
			if(connection==null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "root");
				return connection;
			}
//			System.out.println(connection.hashCode());
			System.out.println("CONNECTION ESTABLISHED SUCCESSFULLY");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
}