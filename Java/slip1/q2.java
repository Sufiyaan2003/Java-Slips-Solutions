// Write a Java program to accept the details of Employee (Eno, EName, Designation,
// Salary) from a user and store it into the database. (Use Swing)

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class q2 extends Frame implements ActionListener {
    Label l1, l2, l3;
    TextField t1, t2, t3;
    Button b;
    Connection cn;
    Statement st;
    ResultSet rs;

    public q2() {
        setLayout(new FlowLayout()); // Using FlowLayout
        l1 = new Label("Eno");
        l2 = new Label("EName");
        l3 = new Label("Salary");
        t1 = new TextField(10); // Specifying column width
        t2 = new TextField(10);
        t3 = new TextField(10);
        b = new Button("Save");
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b);
        b.addActionListener(this);
        setSize(300, 200);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent oe) {
        String str = oe.getActionCommand();
        if (str.equals("Save")) {
            try {
                Class.forName("org.postgresql.Driver");
                cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "");
                st = cn.createStatement();
                int en = Integer.parseInt(t1.getText());
                String enn = t2.getText();
                int sal = Integer.parseInt(t3.getText());
                String strr = "insert into emp values(" + en + ",'" + enn + "'," + sal + ")";
                int k = st.executeUpdate(strr);
                if (k > 0) {
                    JOptionPane.showMessageDialog(null, "Record Is Added");
                }
            } catch (Exception er) {
                er.printStackTrace();
            } finally {
                try {
                    if (st != null)
                        st.close();
                    if (cn != null)
                        cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        new q2();
    }
}
