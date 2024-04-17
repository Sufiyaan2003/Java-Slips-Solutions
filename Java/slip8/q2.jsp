<!-- Write a JSP program to check whether a given number is prime or not. Display the result
in red color. -->

<<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prime Number Checker</title>
</head>
<body>
<h2>Prime Number Checker</h2>

<%!
    // Method to check if a number is prime
    boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
%>

<% 
    // Getting the number from the request parameter
    String numberStr = request.getParameter("number");
    int number = Integer.parseInt(numberStr);
    
    // Checking if the number is prime
    boolean prime = isPrime(number);
    
    // Displaying the result in red color if the number is prime
    if (prime) {
%>
        <p style="color: red;"><%= number %> is a Prime Number</p>
<%
    } else {
%>
        <p><%= number %> is not a Prime Number</p>
<%
    }
%>

<form method="get" action="">
    <label for="number">Enter a number:</label>
    <input type="text" id="number" name="number">
    <button type="submit">Check</button>
</form>
</body>
</html>
