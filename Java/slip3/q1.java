// Write a JSP program to display the details of Patient (PNo, PName, Address, age,
// disease) in tabular form on browser. 

<%@ page import="java.sql.*" %>

<html>
<head>
  <title>Patient Details</title>
</head>
<body>
  <h1>Patient List</h1>
  <table border="1">
    <tr>
      <th>PNo</th>
      <th>PName</th>
      <th>Address</th>
      <th>Age</th>
      <th>Disease</th>
    </tr>
    <%
      try {
        
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Hospital","postgres","");

        Statement stmt = conn.createStatement();
        String query = "SELECT PNo, PName, Address, Age, Disease FROM Patient";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
          int pno = rs.getInt("PNo");
          String pname = rs.getString("PName");
          String address = rs.getString("Address");
          int age = rs.getInt("Age");
          String disease = rs.getString("Disease");
    %>
          <tr>
            <td><%= pno %></td>
            <td><%= pname %></td>
            <td><%= address %></td>
            <td><%= age %></td>
            <td><%= disease %></td>
          </tr>
    <%
        }

        rs.close();
        stmt.close();
        conn.close();
      } catch (Exception e) {
        out.println("Error: " + e.getMessage());
      }
    %>
  </table>
</body>
</html>
