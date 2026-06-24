package com.devanshu.jdbcLearning;

import java.sql.*;

public class LaunchApp2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection connect = JdbcUtil.getConnection();
		// Creating statement
		Statement statement = connect.createStatement();
		// execute query
		String sql = "UPDATE studentinfo set sage=sage+1 where sname='devanshu'";
		int rowsAffected = statement.executeUpdate(sql);

		// process the result\
		if (rowsAffected == 0) {
			System.out.println("unable to update data");
		} else {
			System.out.println("data updated successfully");
		}
		// close the resources

		JdbcUtil.closeConnection(connect, statement);

	}

}
