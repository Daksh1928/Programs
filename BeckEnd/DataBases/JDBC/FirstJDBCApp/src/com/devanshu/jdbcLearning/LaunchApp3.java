package com.devanshu.jdbcLearning;

import java.sql.*;

public class LaunchApp3 {

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
        String sql = "SELECT * FROM studentInfo";
        ResultSet rs = statement.executeQuery(sql);
        // process the result
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            String city = rs.getString(4);
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", City: " + city);
        }
        // close the resources

        statement.close();
        connect.close();

    }

}