package day02;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JDBCUtil;
import util.StringUtil;

public class UpdateEmpServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//指定编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf");
//		PrintWriter out = response.getWriter();
		
		//获取请求中的参数
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String gender = request.getParameter("gender");
		String edu = request.getParameter("edu");
		String[] hobbies = request.getParameterValues("hobbies");
		
		//数据库完成修改功能
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = new StringBuffer()
					.append("update t_emp ")
					.append("set name = ?, ")
					.append("salary = ?, ")
					.append("gender = ?, ")
					.append("edu = ?, ")
					.append("hobbies = ? ")
					.append("where id = ? ")
					.toString();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, salary);
			ps.setString(3, gender);
			ps.setString(4, edu);
			ps.setString(5, StringUtil.arrayToString(hobbies, ","));
			ps.setInt(6, id);
			
			ps.executeUpdate();
			conn.commit();
			
			response.sendRedirect("/web/findAll");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeAll(conn, ps, null);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
