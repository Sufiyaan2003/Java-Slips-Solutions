// Write a java program for the following:
// i. To create a Product(Pid, Pname, Price) table.
// ii. Insert at least five records into the table.
// iii. Display all the records from a table. 

import java.sql.*;

public class q2 {
    // JDBC variables for opening, closing, and managing connection
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            // Establishing connection to the MySQL database
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DYP","postgres", "");

            // Creating table
            createTable();

            // Inserting records into the table
            insertRecords();

            // Displaying all records from the table
            displayRecords();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createTable() throws SQLException {
        statement = connection.createStatement();

        // Creating Product table if not exists
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Product (" +
                                "Pid INT AUTO_INCREMENT PRIMARY KEY," +
                                "Pname VARCHAR(255) NOT NULL," +
                                "Price DECIMAL(10,2) NOT NULL)";
        statement.executeUpdate(createTableSQL);

        System.out.println("Product table created successfully.");
    }

    private static void insertRecords() throws SQLException {
        statement = connection.createStatement();

        // Inserting records into Product table
        String insertRecord1 = "INSERT INTO Product (Pname, Price) VALUES ('Product1', 10.50)";
        String insertRecord2 = "INSERT INTO Product (Pname, Price) VALUES ('Product2', 20.75)";
        String insertRecord3 = "INSERT INTO Product (Pname, Price) VALUES ('Product3', 15.25)";
        String insertRecord4 = "INSERT INTO Product (Pname, Price) VALUES ('Product4', 30.00)";
        String insertRecord5 = "INSERT INTO Product (Pname, Price) VALUES ('Product5', 25.50)";

        statement.executeUpdate(insertRecord1);
        statement.executeUpdate(insertRecord2);
        statement.executeUpdate(insertRecord3);
        statement.executeUpdate(insertRecord4);
        statement.executeUpdate(insertRecord5);

        System.out.println("Records inserted successfully.");
    }

    private static void displayRecords() throws SQLException {
        statement = connection.createStatement();

        // Querying all records from Product table
        String selectSQL = "SELECT * FROM Product";
        resultSet = statement.executeQuery(selectSQL);

        // Displaying records
        System.out.println("Records from Product table:");
        System.out.println("Pid\tPname\tPrice");
        while (resultSet.next()) {
            int pid = resultSet.getInt("Pid");
            String pname = resultSet.getString("Pname");
            double price = resultSet.getDouble("Price");
            System.out.println(pid + "\t" + pname + "\t" + price);
        }
    }
}
