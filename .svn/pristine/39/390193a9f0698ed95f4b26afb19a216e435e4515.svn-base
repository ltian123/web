package day03;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JDBCUtil;
import util.MD5Util;

public class UserServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("===================UserServlet.init()");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("UserServlet.doPost()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("UserServlet.doGet()");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//指定编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		System.out.println("UserServlet.service()");
		String path = request.getServletPath();
		if("/regist.user".equals(path)){
			regist(request, response);
		}
		if("/login.user".equals(path)){
			login(request, response);
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求中的参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//数据查询
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			
			String sql = new StringBuffer()
					.append("select * ")
					.append("from t_user ")
					.append("where name = ? ")
					.append("and password = ? ")
					.toString();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, MD5Util.md5(password));
			rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("登录成功");
				conn.commit();
//				response.sendRedirect(request.getContextPath()+"/day03/welcome.html");
				return;
			}
			System.out.println("登录失败");
		} catch (Exception e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, ps, rs);
			
		}
		
		
		
	}
	
	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("用户正在注册");
		
		
		//获取请求中的参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		
		//将数据保存进数据库
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = new StringBuffer()
					.append("select id,name, ")
					.append("password,phone, ")
					.append("email,address ")
					.append("from t_user ")
					.append("where name = ? ")
					.toString();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
	  		rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("该用户名已经存在,请重新输入");
				conn.commit();
				response.sendRedirect(request.getContextPath()+"/day03/regist.html");
				return;
			}
			
			sql = new StringBuffer()
				.append("insert into ")
				.append("t_user(name,password,phone,email,address) ")
				.append("values(?,?,?,?,?) ")
				.toString();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, MD5Util.md5(password));
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.setString(5, address);
			ps.executeUpdate();
			conn.commit();
			System.out.println("恭喜您,注册成功");
			response.sendRedirect(request.getContextPath()+"/day03/login.html");
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			JDBCUtil.closeAll(conn, ps, rs);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
