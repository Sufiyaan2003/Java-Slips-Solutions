// Design a servlet that provides information about a HTTP request from a client, such as
// IP-Address and browser type. The servlet also provides information about the server on
// which the servlet is running, such as the operating system type, and the names of
// currently loaded servlets. 
//Should be written in cd classes folder

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class q2 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Request Information</title>");
        out.println("</head>");
        out.println("<body>");

        // Client information
        out.println("<h2>Client Information:</h2>");
        out.println("<b>IP Address:</b> " + request.getRemoteAddr() + "<br/>");
        out.println("<b>Browser Type:</b> " + request.getHeader("User-Agent") + "<br/><br/>");

        // Server information
        out.println("<h2>Server Information:</h2>");
        out.println("<b>Server Name:</b> " + request.getServerName() + "<br/>");
        out.println("<b>Server Port:</b> " + request.getServerPort() + "<br/>");
        out.println("<b>Servlet Container:</b> " + getServletContext().getServerInfo() + "<br/>");
        out.println("<b>Operating System:</b> " + System.getProperty("os.name") + "<br/><br/>");

        // Loaded servlets
        out.println("<h2>Loaded Servlets:</h2>");
        Enumeration<String> servletNames = getServletContext().getServletNames();
        while (servletNames.hasMoreElements()) {
            String servletName = servletNames.nextElement();
            out.println("- " + servletName + "<br/>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
