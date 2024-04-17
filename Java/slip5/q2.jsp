<!-- // Create a JSP page for an online multiple choice test. The questions are randomly selected
// from a database and displayed on the screen. The choices are displayed using radio
// buttons. When the user clicks on next, the next question is displayed. When the user
// clicks on submit, display the total score on the screen
 -->

 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Multiple Choice Test</title>
</head>
<body>

<%
    // JDBC URL, username, and password
    String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
    String username = "your_username";
    String password = "your_password";

    // Load the MySQL JDBC driver
    Class.forName("com.mysql.jdbc.Driver");

    // Connect to the database
    Connection conn = DriverManager.getConnection(jdbcUrl, username, password);

    // SQL query to retrieve a random question from the database
    String sql = "SELECT * FROM questions ORDER BY RAND() LIMIT 1";

    // Execute the query
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    if(rs.next()) {
        String questionText = rs.getString("question_text");
        String choice1 = rs.getString("choice1");
        String choice2 = rs.getString("choice2");
        String choice3 = rs.getString("choice3");
        String choice4 = rs.getString("choice4");

        // Display the question and choices with radio buttons
%>
        <h2>Question:</h2>
        <p><%= questionText %></p>
        <form action="submitAnswer.jsp" method="post">
            <input type="radio" name="answer" value="1"><%= choice1 %><br>
            <input type="radio" name="answer" value="2"><%= choice2 %><br>
            <input type="radio" name="answer" value="3"><%= choice3 %><br>
            <input type="radio" name="answer" value="4"><%= choice4 %><br>
            <input type="submit" value="Next">
        </form>
<%
    } else {
        out.println("No questions found in the database.");
    }

    // Close the database connections
    rs.close();
    stmt.close();
    conn.close();
%>

</body>
</html>


<!-- SQL File
create table questions(qid serial primary key, question text, option1
text, option2 text, option3 text, option4 text, ans int);

insert into questions
(question,option1,option2,option3,option4,ans)
values
('Who is prime minister of India?','Rahul Gandhi','Narendra
Modi','Sonia Gandhi','Manmohan Singh',2),
('Who is finance minister of India','Rahul Gandhi','P
Chidambaram','Manmohan Singh','Arun Jately',4),
('What is square root of 16?','2','4','1','256',4),
('Who is chief minister of Maharashtra','Uddhav Tharakey','Devendra
Fadanavis','Raj Thakarey','Sharad Pawar',2),
('What is full for of LIFO?','Last In First Out','Late In First
Out','Long In First Out','Large In First Out',1),
('Which is capital of India','Delhi','Maharashtra','Kolkata','Goa',1),
('What is currency of India','Dollar','Rupee','Pound','Yen',2),
('Who Invented C?','Kim Thompson','Bill Joy','Dennis Ritche','Balaguru
Swamy',3),
('Where was Java invented?','Microsoft','Oracle','Sun
Microsystem','Intel',3),
('What is cube root of 8?','2','3','4','5',1),('What is full form of
FIFO','Fast In Fast Out','First in First Out','Fast In First
Out','First In Fast Out',2);  -->
