<!-- Create a JSP page to accept a number from a user and display it in words: Example:
123 – One Two Three. The output should be in red color.  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Number to Words Converter</title>
<style>
 .red {
 color: red;
 }
</style>
</head>
<body>
 <h1>Number to Words Converter</h1>
 <form method="post">
 Enter a number: <input type="text" name="number" /><br />
 <input type="submit" value="Convert" />
 </form>
 <br />
 <%-- Get the number from the request parameter --%>
 <% String numberStr = request.getParameter("number"); %>
 <%-- Check if the number is not null and not empty --%>
 <% if (numberStr != null && !numberStr.trim().isEmpty()) { %>
 <%-- Convert the number to words --%>
 <% String[] words = { "Zero", "One", "Two", "Three", "Four", "Five", "Six",
"Seven", "Eight", "Nine" }; %>
 <% String number = numberStr.trim(); %>
 <span class="red">
 <% for (int i = 0; i < number.length(); i++) { %>
 <%= words[Character.getNumericValue(number.charAt(i))] + " " %>
 <% } %>
 </span>
 <% } %>
</body>
</html> 