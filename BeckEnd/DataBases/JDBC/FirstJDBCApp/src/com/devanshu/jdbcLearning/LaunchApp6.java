package com.devanshu.jdbcLearning;

import java.sql.*;

public class LaunchApp6 {

    public static void main(String[] args) {
        Connection connect = null;
        Statement statement = null;
        try {
            // Load and Register The Drivers
            connect = JdbcUtil.getConnection();

            // Establish the connection

            // Creating statement
            statement = connect.createStatement();
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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.closeConnection(connect, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("Finally Block Executed");

        }
    }
}