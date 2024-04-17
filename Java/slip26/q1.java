// Write a Java program to delete the details of given employee (ENo EName Salary).
// Accept employee ID through command line. (Use PreparedStatement Interface)

import java.sql.*;

public class q1 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DYP", "postgres", "");

            // Step 3: Create a prepared statement to delete the employee details
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM Employee WHERE ENo=?");
            // Step 4: Set the employee ID parameter for the prepared statement
            int employeeID = Integer.parseInt(args[0]);
            pstmt.setInt(1, employeeID);

            // Step 5: Execute the prepared statement
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");

            // Step 6: Close the resources
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}