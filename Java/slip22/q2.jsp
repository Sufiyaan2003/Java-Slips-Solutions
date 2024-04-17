<!-- Write a JSP program which accepts UserName in a TextBox and greets the user
according to the time on server machine. -->

<%@ page language="java" %> 
<html>
<head>
<title>Greeting Page</title>
</head>
<body>
<h1>Welcome to our website</h1>
<%
String userName = request.getParameter("userName"); // retrieve user input
from the form
String greetingMessage = "Hello, " + userName;
java.util.Date date = new java.util.Date(); // get the current date and time
java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss
a"); // format the date and time
int hour = Integer.parseInt(sdf.format(date).substring(0, 2)); // extract the hour
from the formatted date
if (hour >= 0 && hour < 12) {
 greetingMessage += ". Good morning!";
} else if (hour >= 12 && hour < 18) {
 greetingMessage += ". Good afternoon!";
} else {
 greetingMessage += ". Good evening!";
}
%> 
<p><%= greetingMessage %></p>
<form action="greeting.jsp" method="get">
 Enter your name: <input type="text" name="userName">
 <input type="submit" value="Submit">
</form>
</body>
</html> 