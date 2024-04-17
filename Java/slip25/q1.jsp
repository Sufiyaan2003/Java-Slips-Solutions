<!-- Write a JSP program to accept Name and Age of Voter and check whether he is
eligible for voting or not.  -->

<%@ page language="java" %>
<%@ page import="java.io.*, java.util.*" %>
<%
 String name = request.getParameter("name");
 int age = Integer.parseInt(request.getParameter("age"));
 if (age >= 18) {
 out.println("<h3>" + name + ", you are eligible to vote.</h3>");
 } else {
 out.println("<h3>" + name + ", you are not eligible to vote.</h3>");
 }
%>

<form method="post" action="">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" required><br><br>

    <label for="age">Age:</label>
    <input type="number" name="age" id="age" required><br><br>

    <input type="submit" value="Check Eligibility">
</form>