package day04;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String path = "a";
		String uriPath = request.getRequestURI();
		System.out.println("uri:"+uriPath);
		String contextPath = request.getContextPath();
		System.out.println("contextPath:"+contextPath);
		String servletPath = request.getServletPath();
		System.out.println("servletPath:"+servletPath);
		
		
		System.out.println("contextPath+servletPath:"+contextPath+servletPath);
		
		int i = 0;
//		int i =1;
		
		String path = uriPath.substring((contextPath+servletPath).length());
		System.out.println("path:"+path);
		
		
		
		
//		request.getRequestDispatcher("/WEB-INF/a.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/"+path+".jsp").forward(request, response);
	}
}
