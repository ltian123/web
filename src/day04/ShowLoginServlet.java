package day04;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieUtil;

public class ShowLoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = CookieUtil.findCookie("name", request);
		String password = CookieUtil.findCookie("password", request);
		if(name==null || password==null){
			request.getRequestDispatcher("/day04/login.jsp").forward(request, response);
			return;
		}
		
		if("admin".equals(name) && "123".equals(password)){
			request.getRequestDispatcher("/day04/success.jsp").forward(request, response);
			return;
		}
		CookieUtil.removeCookie("name", response);
		CookieUtil.removeCookie("password", response);
		response.sendRedirect(request.getContextPath()+"/day04/login.jsp");
		
		
		
		
	}
	
}
