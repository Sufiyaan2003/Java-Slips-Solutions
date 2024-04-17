// Write a Menu Driven program in Java for the following: Assume Employee table with
// attributes (ENo, EName, Salary) is already created. 1. Insert 2. Update 3. Display 4.
// Exit. 
import java.io.*;
import java.sql.*;

public class q1 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DYP", "postgres", "");
            stmt = conn.createStatement();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int choice;
            do {
                System.out.println("Menu:");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(br.readLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter employee number: ");
                        int eno = Integer.parseInt(br.readLine());
                        System.out.print("Enter employee name: ");
                        String ename = br.readLine();
                        System.out.print("Enter employee salary: ");
                        double salary = Double.parseDouble(br.readLine());
                        String sql = "INSERT INTO Employee (ENo, EName, Salary) VALUES(" + eno + ", '" + ename + "', " + salary + ")";
                        stmt.executeUpdate(sql);
                        System.out.println("Record inserted successfully.");
                        break;
                    case 2:
                        System.out.print("Enter employee number: ");
                        eno = Integer.parseInt(br.readLine());
                        System.out.print("Enter new employee name: ");
                        ename = br.readLine();
                        System.out.print("Enter new employee salary: ");
                        salary = Double.parseDouble(br.readLine());
                        sql = "UPDATE Employee SET EName='" + ename + "', Salary=" + salary + " WHERE ENo=" + eno;
                        int rowsAffected = stmt.executeUpdate(sql);
                        if (rowsAffected == 0) {
                            System.out.println("No records found with employee number "
                                    + eno);
                        } else {
                            System.out.println(rowsAffected + " record(s) updated successfully.");
                        }
                        break;
                    case 3:
                        sql = "SELECT * FROM Employee";
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            eno = rs.getInt("ENo");
                            ename = rs.getString("EName");
                            salary = rs.getDouble("Salary");
                            System.out.println("Employee number: " + eno + ", Employee name: " + ename + ", Employee salary: " + salary);
                        }
                        rs.close();
                        break;
                    case 4:
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 4);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}