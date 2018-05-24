package day01;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		int i = 1/0;
//		String name = request.getParameter("name");
		String name = request.getParameter("username");
		PrintWriter out = response.getWriter();
		out.print("<h1><font color=\"red\">Hello "+name+"</font></h1>");
	}
}
