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
		//ָ������
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
		//��ȡ�����еĲ���
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//���ݲ�ѯ
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
				System.out.println("��¼�ɹ�");
				conn.commit();
//				response.sendRedirect(request.getContextPath()+"/day03/welcome.html");
				return;
			}
			System.out.println("��¼ʧ��");
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
		System.out.println("�û�����ע��");
		
		
		//��ȡ�����еĲ���
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		
		//�����ݱ�������ݿ�
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
				System.out.println("���û����Ѿ�����,����������");
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
			System.out.println("��ϲ��,ע��ɹ�");
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
