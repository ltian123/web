package day03;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Emp;

import util.JDBCUtil;
import util.StringUtil;

public class EmpServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//指定编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String path = request.getServletPath();
		if("/findAll.emp".equals(path)){
			findAll(request, response);
		}
		if("/add.emp".equals(path)){
			addEmp(request, response);
		}
		if("/deleteById.emp".equals(path)){
			deleteById(request, response);
		}
		if("/findById.emp".equals(path)){
			findById(request, response);
		}
		
		if("/update.emp".equals(path)){
			updateEmp(request, response);
		}
		
	}
	
	protected void updateEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求中的参数
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String gender = request.getParameter("gender");
		String edu = request.getParameter("edu");
		String[] hobbies = request.getParameterValues("hobbies");
		
		
		//..
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
			ps.setDouble(2, Double.parseDouble(salary));
			ps.setString(3, gender);
			ps.setString(4, edu);
			ps.setString(5, StringUtil.arrayToString(hobbies, ","));
			ps.setInt(6, id);
			ps.executeUpdate();
			conn.commit();
			response.sendRedirect(request.getContextPath()+"/findAll.emp");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			JDBCUtil.closeAll(conn, ps, null);
		}
		
		
	}
	
	protected void findById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emp emp = new Emp();
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = new StringBuffer()
					.append("select *  ")
					.append("from t_emp ")
					.append("where id = ? ")
					.toString();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setGender(rs.getString("gender"));
				emp.setEdu(rs.getString("edu"));
				emp.setHob(rs.getString("hobbies"));
			}
			conn.commit();
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("/day04/update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally{
				JDBCUtil.closeAll(conn, ps, rs);
				
			}
		}
	}
	
	protected void deleteById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求中的参数
		int id = Integer.parseInt(request.getParameter("id"));
		
		//JDBC操作
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = new StringBuffer()
					.append("delete from t_emp ")
					.append("where id = ? ")
					.toString();
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.commit();
			
			response.sendRedirect(request.getContextPath()+"/findAll.emp");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			JDBCUtil.closeAll(conn, ps, null);
		}
		
		
		
		
		
		
	}
	
	protected void addEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String gender = request.getParameter("gender");
		String edu = request.getParameter("edu");
		String[] hobbies = request.getParameterValues("hobbies");
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = new StringBuffer()
					.append("insert into ")
					.append("t_emp(name,salary,gender,edu,hobbies) ")
					.append("values(?,?,?,?,?) ")
					.toString();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, Double.parseDouble(salary));
			ps.setString(3, gender);
			ps.setString(4, edu);
			ps.setString(5, StringUtil.arrayToString(hobbies, ","));
			ps.executeUpdate();
			conn.commit();
			response.sendRedirect(request.getContextPath()+"/findAll.emp");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			JDBCUtil.closeAll(conn, ps, null);
		}
		
		
		
		
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = new StringBuffer()
					.append("select * ")
					.append("from t_emp")
					.toString();
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Emp emp = new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setGender(rs.getString("gender"));
				emp.setEdu(rs.getString("edu"));
				emp.setHob(rs.getString("hobbies"));
				emps.add(emp);
			}
			request.setAttribute("emps", emps);
			request.getRequestDispatcher("/day03/findAllEmp.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeAll(conn, ps, rs);
		}
		
		
		
	}
	
	
}
