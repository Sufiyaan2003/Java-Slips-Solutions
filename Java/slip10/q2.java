// Write a Java program to display first record from student table (RNo, SName, Per) onto
// the TextFields by clicking on button. (Assume Student table is already created)

import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class q2 extends JFrame implements ActionListener {
    JTextField t1, t2, t3;
    JLabel l1, l2, l3;
    JButton b1, b2;
    int row, column;

    q2() {
        setLayout(new FlowLayout());
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("RollNo");
        add(l1);

        t1 = new JTextField(10);
        add(t1);

        l2 = new JLabel("Name");
        add(l2);

        t2 = new JTextField(10);
        add(t2);

        l3 = new JLabel("Percentage");
        add(l3);

        t3 = new JTextField(10);
        add(t3);

        b1 = new JButton("Insert");
        add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Display");
        add(b2);
        b2.addActionListener(this);

        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e2) {
        if (e2.getSource() == b1) {
            try {
                int eno = Integer.parseInt(t1.getText());
                String ename = t2.getText();
                float percentage = Float.parseFloat(t3.getText());

                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/DYP", "postgres", "");

                PreparedStatement st = conn.prepareStatement("insert into student values(?,?,?)");
                st.setInt(1, eno);
                st.setString(2, ename);
                st.setFloat(3, percentage);
                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(this, "Inserted");

            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }
        if (e2.getSource() == b2) {
            try {

                Object[] data = new Object[3];
                DefaultTableModel dtm = new DefaultTableModel();
                JTable jt = new JTable(dtm);
                ResultSet rs;
                System.out.println("hello");
                jt.setBounds(20, 20, 50, 50);
                String[] darr = { "RollNo", "Name", "Percentage" };
                for (int column = 0; column < 3; column++) {
                    dtm.addColumn(darr[column]);
                }
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/DYP", "postgres", "");
                Statement st = conn.createStatement();
                rs = st.executeQuery("select * from student");
                for (row = 0; rs.next(); row++) {
                    for (int column = 0; column < 3; column++) {
                        data[column] = rs.getObject(column + 1);
                    }
                    dtm.addRow(data);
                }
                rs.close();
                getContentPane().add(new JScrollPane(jt));
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        new q2();
    }

}