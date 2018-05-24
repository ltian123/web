package day01;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class HelloServlet extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response)				throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello Servlet</h1>");
	}
}