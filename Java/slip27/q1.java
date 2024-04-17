// Write a Java Program to display the details of College (CID, CName, address, Year)
// on JTable. 

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class q1 extends JFrame {

    public q1() {
        super("College Details");

        // create a JTable
        JTable table = new JTable();

        // set column names for the table
        String[] columnNames = { "CID", "CName", "Address", "Year" };

        // create a default table model with the column names
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // add data to the table model
        try {
            // create a database connection
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DYP", "postgres", "");
            // create a statement
            Statement stmt = conn.createStatement();

            // execute a query to get college details
            ResultSet rs = stmt.executeQuery("SELECT * FROM college");

            // add each row to the table model
            while (rs.next()) {
                String cid = rs.getString("CID");
                String cname = rs.getString("CName");
                String address = rs.getString("Address");
                int year = rs.getInt("Year");
                model.addRow(new Object[] { cid, cname, address, year });
            }

            // close the result set, statement and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // set the table model to the JTable
        table.setModel(model);
        // create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);

        // add the scroll pane to the frame
        getContentPane().add(scrollPane);

        // set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new q1();
    }
}