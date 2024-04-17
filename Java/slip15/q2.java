// Write a SERVLET program which counts how many times a user has visited a web
// page. If user is visiting the page for the first time, display a welcome message. If the
// user is revisiting the page, display the number of times visited. (Use Cookie)
// cd classes folder

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class q2 extends HttpServlet {
    static int i = 1;

 public void doGet(HttpServletRequest request,HttpServletResponse
 response)
  throws IOException,ServletException
  {
  response.setContentType("text/html");
  PrintWriter out=response.getWriter();
  String k=String.valueOf(i);
  Cookie c=new Cookie("visit",k);
  response.addCookie(c);
  int j=Integer.parseInt(c.getValue());
  if(j==1)
  {
  out.println("Welcome to web page ");
  }
  else {
  out.println("You are visited at "+i+" times");
  }
  i++;
 }
}