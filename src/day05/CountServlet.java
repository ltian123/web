package day05;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer count = (Integer) session.getAttribute("count");
		if(count ==null){
			count = 1;
		}else{
			count++;
		}
		session.setAttribute("count", count);
		request.getRequestDispatcher("/day05/count.jsp").forward(request, response);
	}
}
