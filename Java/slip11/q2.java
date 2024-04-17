// Write a Java program to display information about all columns in the DONAR table
// using ResultSetMetaData.

import java.sql.*;
import java.io.*;

public class q2 {
    public static void main(String[] args) throws Exception {

        Statement stmt;
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/stud", "postgres", "");
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from student");
        java.sql.ResultSetMetaData rsmd = rs.getMetaData();
        int noOfColumns = rsmd.getColumnCount();
        System.out.println("Number of columns = " + noOfColumns);
        for (int i = 1; i <= noOfColumns; i++) {
            System.out.println("Column No : " + i);
            System.out.println("Column Name : " + rsmd.getColumnName(i));
            System.out.println("Column Type : " + rsmd.getColumnTypeName(i));
            System.out.println("Column display size : " + rsmd.getColumnDisplaySize(i));
        }
        conn.close();
    }
}