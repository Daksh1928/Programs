package com.devanshu.jdbcLearning;

import java.sql.*;
import java.util.Scanner;

public class LaunchAppBatch {

    public static void main(String[] args) {
        Connection connect = null;
        PreparedStatement pstmnt = null;

        try {
            connect = JdbcUtil.getConnection();
            String sql = "UPDATE studentinfo SET sage=? WHERE id=?";
            pstmnt = connect.prepareStatement(sql);

            pstmnt.setInt(1, 202);
            pstmnt.setInt(2, 12);
            pstmnt.addBatch();
            pstmnt.setInt(1, 192);
            pstmnt.setInt(2, 44);
            pstmnt.addBatch();

            int[] rowsAffected = pstmnt.executeBatch();
            // process the result\
            if (rowsAffected.length == 0) {
                System.out.println("unable to update data");
            } else {
                System.out.println("data updated successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
