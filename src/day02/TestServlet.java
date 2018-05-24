package day02;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//返回的是自定义应用名
		String contextPath = request.getContextPath();
		System.out.println("contextPath:"+contextPath);
		
		//返回的是servlet请求名(也就是url-pattern)
		String servletPath = request.getServletPath();
		System.out.println("servletPath:"+servletPath);
		
		//返回的是浏览器地址栏完整的URL地址
		StringBuffer url = request.getRequestURL();
		System.out.println("url:"+url.toString());
		
		//返回的是端口号后面的路径,相当于contextPath+servletPath
		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		
		//返回的是访问当前服务器的用户所在的ip地址
		String ip = request.getRemoteAddr();
		System.out.println("ip:"+ip);
		
		//返回的是请求方式
		String method = request.getMethod();
		System.out.println("method:"+method);
		
		String name = request.getParameter("name");
		String[] hobbies = request.getParameterValues("hobbis");
		
	}
}
