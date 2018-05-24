package day04;


import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieUtil;

public class SaveCookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Cookie cookie1 = new Cookie("name", "aaa");
//		Cookie cookie2 = new Cookie("password", "admin");
//		Cookie cookie3 = new Cookie("username", "管理员admin");
		
//		String username = "管理员";
		//将username转换成utf-8的编码
//		username = URLEncoder.encode(username, "utf-8");
//		Cookie cookie3 = new Cookie("username", username);
		
//		cookie1.setMaxAge(3600);
//		cookie1.setMaxAge(0);
//		response.addCookie(cookie1);
//		response.addCookie(cookie2);
//		response.addCookie(cookie3);
		CookieUtil.addCookie("name", "管理员", response);
		CookieUtil.addCookie("password", "admin", response);
		
	}
	
}
