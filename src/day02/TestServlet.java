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
		
		//���ص����Զ���Ӧ����
		String contextPath = request.getContextPath();
		System.out.println("contextPath:"+contextPath);
		
		//���ص���servlet������(Ҳ����url-pattern)
		String servletPath = request.getServletPath();
		System.out.println("servletPath:"+servletPath);
		
		//���ص����������ַ��������URL��ַ
		StringBuffer url = request.getRequestURL();
		System.out.println("url:"+url.toString());
		
		//���ص��Ƕ˿ںź����·��,�൱��contextPath+servletPath
		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		
		//���ص��Ƿ��ʵ�ǰ���������û����ڵ�ip��ַ
		String ip = request.getRemoteAddr();
		System.out.println("ip:"+ip);
		
		//���ص�������ʽ
		String method = request.getMethod();
		System.out.println("method:"+method);
		
		String name = request.getParameter("name");
		String[] hobbies = request.getParameterValues("hobbis");
		
	}
}
