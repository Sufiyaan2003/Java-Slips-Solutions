// Write a Java Program to create a PROJECT table with field’s project_id, Project_name,
// Project_description, Project_Status. Insert values in the table. Display all the details of
// the PROJECT table in a tabular format on the screen.(using swing).

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class q2 extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2, b3;
    String sql;
    JPanel p, p1;
    Connection con;
    PreparedStatement ps;
    JTable t;
    JScrollPane js;
    Statement stmt;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columns;
    Vector columnNames = new Vector();
    Vector data = new Vector();

    q2() {
        l1 = new JLabel("Enter no :");
        l2 = new JLabel("Enter name :");
        l3 = new JLabel("percentage :");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        b1 = new JButton("Save");
        b2 = new JButton("Display");
        b3 = new JButton("Clear");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        p = new JPanel();
        p1 = new JPanel();
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        add(p);
        setLayout(new GridLayout(2, 1));
        setSize(600, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if ((JButton) b1 == e.getSource()) {
            int no = Integer.parseInt(t1.getText());
            String name = t2.getText();
            int p = Integer.parseInt(t3.getText());
            System.out.println("Accept Values");
            try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql://localhost/stud", "postgres", "");

                sql = "insert into stud values(?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, no);
                ps.setString(2, name);
                ps.setInt(3, p);
                System.out.println("values set");
                int n = ps.executeUpdate();
                if (n != 0) {
                    JOptionPane.showMessageDialog(null, "Record insered ...");
                } else
                    JOptionPane.showMessageDialog(null, "Record NOT inserted ");
            } // end of try
            catch (Exception ex) {
                System.out.println(ex);
                // ex.printStackTrace();
            }
        } // end of if
        else if ((JButton) b2 == e.getSource()) {
            try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql://localhost/stud", "postgres", "");
                System.out.println("Connected");
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from stud");
                rsmd = rs.getMetaData();
                columns = rsmd.getColumnCount();
                // Get Columns name
                for (int i = 1; i <= columns; i++) {
                    columnNames.addElement(rsmd.getColumnName(i));
                }
                // Get row data
                while (rs.next()) {
                    Vector row = new Vector(columns);
                    for (int i = 1; i <= columns; i++) {
                        row.addElement(rs.getObject(i));
                    }
                    data.addElement(row);
                }
                t = new JTable(data, columnNames);
                js = new JScrollPane(t);
                p1.add(js);
                add(p1);
                setSize(600, 600);
                setVisible(true);
            } catch (Exception e1) {
                System.out.println(e1);
            }
        } else {
            t1.setText(" ");
            t2.setText(" ");
            t3.setText(" ");
        }
    }// end of method

    public static void main(String a[]) {
        q2 ob = new q2();
    }
}
