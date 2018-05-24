package day03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestOneServlet implements Servlet {

	private ServletConfig config;
	
	public void destroy() {
		System.out.println("******************TestOneServlet.destroy()******************");
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	public void init(ServletConfig config) throws ServletException {
		
		this.config =config;
		System.out.println("******************TestOneServlet.init()******************");
	}
	
	

	public void service(ServletRequest req, ServletResponse arg1)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		System.out.println("******************TestOneServlet.service()******************");
		String aa = config.getInitParameter("aa");
		System.out.println(aa);
		
	}
	
	

}
