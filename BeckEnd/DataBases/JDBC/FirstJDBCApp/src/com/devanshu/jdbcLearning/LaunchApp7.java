package com.devanshu.jdbcLearning;

import java.sql.*;
import java.util.Scanner;

public class LaunchApp7 {

    public static void main(String[] args) {
        Connection connect = null;
        Statement statement;
        PreparedStatement pstmnt = null;
        try {
            // Load and Register The Drivers
            connect = JdbcUtil.getConnection();

            // Establish the connection

            // Creating statement
            // statement = connect.createStatement();
            // execute query
            String query = "INSERT INTO studentinfo(id,sname,sage,scity ) VALUES(?,?,?,?)";
            pstmnt = connect.prepareStatement(query);

            System.out.println("Please enter the following details to be stored in Data Base ");
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your Id ");
            Integer id = scan.nextInt();
            System.out.println("Enter your name : ");
            String name = scan.next();

            System.out.println("Enter your age ");
            Integer age = scan.nextInt();

            System.out.println("Enter your city ");
            String city = scan.next();

            pstmnt.setInt(1, id);
            pstmnt.setString(2, name);
            pstmnt.setInt(3, age);
            pstmnt.setString(4, city);
            int rowsAffected = pstmnt.executeUpdate();

            // process the result\
            if (rowsAffected == 0) {
                System.out.println("unable to update data");
            } else {
                System.out.println("data updated successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.closeConnection(connect, pstmnt);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("Finally Block Executed");

        }
    }
}