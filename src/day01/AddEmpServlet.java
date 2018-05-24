package day01;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.StringUtil;


import constant.JDBCConstant;

public class AddEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//指定编码
		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String a = request.getParameter("a");
		System.out.println("a:"+a);
		
		
		Map<String,String[]> map = request.getParameterMap();
		Set<Entry<String, String[]>> set = map.entrySet();
		Iterator<Entry<String, String[]>> it = set.iterator();
		while(it.hasNext()){
			Entry<String, String[]> entry = it.next();
			System.out.println("key:"+entry.getKey());
			System.out.print("values:");
			for(String s : entry.getValue()){
				System.out.print(s+",");
			}
			System.out.println();
		}
		
		
		/*//获取请求中的参数
		String name = request.getParameter("name");
//		double salary = Double.parseDouble(request.getParameter("salary"));
		String gender = request.getParameter("gender");
		String edu = request.getParameter("edu");
//		String hobbies = request.getParameter("hobbies");
		String[] hobbies = request.getParameterValues("hobbies");
		
//		name = new String(name.getBytes("ISO8859-1"),"utf-8");
		
//		System.out.println("name="+name+",salary="+salary+",gender="+gender+",edu="+edu+",hobbies="+Arrays.toString(hobbies));
		System.out.println("name="+name+",gender="+gender+",edu="+edu+",hobbies="+Arrays.toString(hobbies));
		*/
		
		//将数据保存到数据库
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//注册驱动
//			Class.forName(JDBCConstant.JDBC_DRIVER);
			//获取连接
//			conn = DriverManager.getConnection(JDBCConstant.JDBC_CONNECTION_URL, JDBCConstant.JDBC_CONNECTION_USERNAME, JDBCConstant.JDBC_CONNECTION_PASSWORD);
//			conn.setAutoCommit(false);
			//数据库操作语句
//			String sql = new StringBuffer()
//					.append("insert into t_emp ")
//					.append("(name,salary,gender,edu,hobbies) ")
//					.append("values(?,?,?,?,?) ")
//					.toString();
			//获取状态集
//			ps = conn.prepareStatement(sql);
			//传参
//			ps.setString(1, name);
//			ps.setDouble(2, salary);
//			ps.setString(3, gender);
//			ps.setString(4, edu);
//			ps.setString(5, StringUtil.arrayToString(hobbies, ","));
//			ps.executeUpdate();
//			conn.commit();
			//生成响应返回给浏览器
//			out.print("<h1><font color='green'>恭喜您,"+name+"用户信息添加成功</font></h1>");
//			request.getRequestDispatcher("url地址").forward(request, response);
//			response.sendRedirect("url地址");
//			response.sendRedirect("/web/findAll");
//			response.sendRedirect("http://bbs.itany.com");
//			request.getRequestDispatcher("/findAll").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			//返回响应结果给浏览器
//			out.print("<h1><font color='red'>对不起,"+name+"用户信息添加失败</font></h1>");
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
