package com.devanshu.jdbcLearning;

import java.sql.*;

public class LaunchApp1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Load and Register The Drivers
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish the connection
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "dev@123";
		Connection connect = DriverManager.getConnection(url, user, password);
		// Creating statement
		Statement statement = connect.createStatement();
		// execute query
		String sql = "INSERT INTO studentInfo(id,sname,sage,scity) VALUES(3,'Devansh',23,'Mombay')";
		int rowsAffected = statement.executeUpdate(sql);

		// process the result\
		if (rowsAffected == 0) {
			System.out.println("unable to insert data");
		} else {
			System.out.println("data inserted successfully");
		}
		// close the resources

		statement.close();
		connect.close();

	}

}
