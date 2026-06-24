package com.devanshu.jdbcLearning;

import java.sql.*;

public class LaunchApp4 {

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
        String sql = "DELETE FROM studentinfo WHERE id = 3";
        int rowsAffected = statement.executeUpdate(sql);
        // close the resources
        if (rowsAffected > 0) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("No record found with the specified ID.");
        }

        statement.close();
        connect.close();

    }

}