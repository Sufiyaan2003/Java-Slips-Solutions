// Write a Java program to display information about the database and list all the tables in
// the database. (Use DatabaseMetaData).

import java.sql.*;
import java.io.*;

public class q1 {
    public static void main(String[] args) throws Exception {
        ResultSet rs = null;
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/DYP", "postgres", "");
        DatabaseMetaData dbmd = conn.getMetaData();
        System.out.println("Database Product name = " + dbmd.getDatabaseProductName());
        System.out.println("User name = " + dbmd.getUserName());
        System.out.println("Database driver name= " + dbmd.getDriverName());
        System.out.println("Database driver version = " + dbmd.getDriverVersion());
        System.out.println("Database product name = " + dbmd.getDatabaseProductName());
        System.out.println("Database Version = " + dbmd.getDriverMajorVersion());
        rs = dbmd.getTables(null, null, null, new String[] { "TABLE" });
        System.out.println("List of tables...");
        while (rs.next()) {
            String tblName = rs.getString("TABLE_NAME");
            System.out.println("Table : " + tblName);
        }
        conn.close();
    }
}