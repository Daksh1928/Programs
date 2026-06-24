package com.devanshu.jdbcLearning;

import java.sql.*;

public class LaunchApp5 {

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
        String sql = "UPDATE studentinfo SET sname = 'Evanshu' WHERE id = 1";
        boolean status = statement.execute(sql);
        // Process the result
        if (status) {
            System.out.println("IF Block Executed");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("sname"));
                System.out.println("Age: " + resultSet.getInt("sage"));
                System.out.println("City: " + resultSet.getString("scity"));
                System.out.println("------------------------");
            }
        } else {
            System.out.println("ELSE Block Executed");
            int rows = statement.getUpdateCount();
            if (rows == 0) {
                System.out.println("Operation failed");
            } else {
                System.out.println("Operation successful. Rows affected: " + rows);
            }
        }
        // close the resources

        statement.close();
        connect.close();

    }

}