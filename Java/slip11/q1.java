// Design an HTML page which passes customer number to a search servlet. The servlet
// searches for the customer number in a database (customer table) and returns customer
// details if found the number otherwise display error message. 
// write in cd classes folder

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class q1 extends HttpServlet {
    Connection cn;

    public void init() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            cn = DriverManager.getConnection("jdbc:postgresql://localhost/DYP", "postgres", "");
            System.out.println("Hii");
        } catch (Exception ce) {
            System.out.println("Error" + ce.getMessage());
        }

    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        try {
            int rno = Integer.parseInt(req.getParameter("t1"));
            String qry = "Select * from student where rollno=" + rno;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                pw.print("<table border=1>");
                pw.print("<tr>");
                pw.print("<td>" + rs.getInt(1) + "</td>");
                pw.print("<td>" + rs.getString(2) + "</td>");
                pw.print("<td>" + rs.getFloat(3) + "</td>");
                pw.print("</tr>");
                pw.print("</table>");
            }
        } catch (Exception se) {
        }
        pw.close();
    }
}