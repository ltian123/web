package day04;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieUtil;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//指定编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if("admin".equals(name) && "123".equals(password)){
			CookieUtil.addCookie("name", name, response);
			CookieUtil.addCookie("password", password, response);
			
//			request.setAttribute("name", "admin");
			request.getRequestDispatcher("/day04/success.jsp").forward(request, response);
			return;
			
		}
		
		request.setAttribute("msg", "用户名或密码错误");
		request.getRequestDispatcher("/day04/login.jsp").forward(request, response);
		
		
		
		
		
	}
}
