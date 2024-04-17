// Write a Java Program for the implementation of scrollable ResultSet. Assume Teacher
// table with attributes (TID, TName, Salary) is already created. 

import java.sql.*;

public class q2 {
    public static void main(String[] args) {
        try {
            // Register JDBC driver
            Class.forName("org.postgresql.Driver");
            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DYP", "postgres", "");
            // Create a Statement object with scrollable ResultSet
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // Execute a query and get the ResultSet object
            ResultSet rs = stmt.executeQuery("SELECT * FROM Teacher");
            // Move the cursor to the last row
            rs.last();
            // Get the total number of rows in the ResultSet
            int rowCount = rs.getRow();
            // Move the cursor back to the first row
            rs.beforeFirst();
            // Display the column headers
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rsmd.getColumnName(i) + "\t");
            }
            System.out.println();
            // Iterate through the ResultSet and display the data
            while (rs.next()) {
                System.out.print(rs.getInt("TID") + "\t");
                System.out.print(rs.getString("TName") + "\t");
                System.out.print(rs.getInt("Salary") + "\t");
                System.out.println();
            }
            // Close the ResultSet, Statement, and Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}