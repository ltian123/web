package day04;


import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieUtil;

public class findCookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Cookie[] cookies = request.getCookies();
//		for (Cookie cookie : cookies) {
//			String name = cookie.getName(); 
//			System.out.println("cookieÃû³Æ:"+name);
//			String value = URLDecoder.decode(cookie.getValue(),"utf-8");
//			System.out.println("cookieÄÚÈÝ:"+value);
//		}
		String value = CookieUtil.findCookie("name", request);
		System.out.println(value);
	}
}
