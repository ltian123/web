package day04;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test3Servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.sendRedirect(request.getContextPath()+"/WEB-INF/a.jsp");
		request.getRequestDispatcher("/WEB-INF/b.jsp").forward(request, response);
		int i =1;
	}
}
