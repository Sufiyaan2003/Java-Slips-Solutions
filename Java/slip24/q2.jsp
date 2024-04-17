<!-- Write a JSP script to accept username and password from user, if they are same then
display “Login Successfully” message in Login.html file, otherwise display “Login
Failed” Message in Error.html file -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if username and password are the same
        if (username != null && password != null && username.equals(password)) {
            // Redirect to login-success.html if login is successful
            response.sendRedirect("login-success.html");
        } else {
            // Redirect to error.html if login fails
            response.sendRedirect("error.html");
        }
    %>
</body>
</html>
