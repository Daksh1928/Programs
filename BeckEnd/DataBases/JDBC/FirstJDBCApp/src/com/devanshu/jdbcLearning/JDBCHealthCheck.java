package com.devanshu.jdbcLearning;

import java.sql.*;
import java.util.Random;

public class JDBCHealthCheck {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "dev@123";

        String[] names = { "Aman", "Riya", "Rahul", "Neha", "Ankit" };
        String[] courses = { "Java", "Python", "C++", "Web Dev", "DBMS" };
        Random random = new Random();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connected to MySQL successfully ✅");

                String insertQuery = "INSERT INTO student (name, course, marks) VALUES (?, ?, ?)";
                try (PreparedStatement ps = con.prepareStatement(insertQuery)) {
                    for (int i = 0; i < 5; i++) {
                        String name = names[random.nextInt(names.length)];
                        String course = courses[random.nextInt(courses.length)];
                        int marks = 50 + random.nextInt(51);

                        ps.setString(1, name);
                        ps.setString(2, course);
                        ps.setInt(3, marks);

                        ps.executeUpdate();
                    }
                }

                System.out.println("Random data inserted successfully ✅");

                try (Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM student")) {

                    while (rs.next()) {
                        System.out.println(
                                "ID: " + rs.getInt("id") +
                                        ", Name: " + rs.getString("name") +
                                        ", Course: " + rs.getString("course") +
                                        ", Marks: " + rs.getInt("marks"));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}