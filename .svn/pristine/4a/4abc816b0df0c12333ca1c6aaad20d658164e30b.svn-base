package day02;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JDBCUtil;
import util.StringUtil;


public class FindByIdServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//指定编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		int i = 1/0;
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		PrintWriter out = response.getWriter();
		
		//获取请求中的参数
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		//根据id查询员工信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = new StringBuffer()
					.append("select id,name, ")
					.append("salary,gender, ")
					.append("edu,hobbies ")
					.append("from t_emp ")
					.append("where id = ? ")
					.toString();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				String gender = rs.getString("gender");
				String edu = rs.getString("edu");
				String hobbies = rs.getString("hobbies");
				out.print("<!DOCTYPE html>");
				out.print("<html>");
				out.print("  <head>");
				out.print("    <title>修改员工信息</title>");
				out.print("    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
				out.print("  </head>");
				out.print("  <body>");
				out.print("  	<h1>修改员工信息</h1>");
				out.print("  	<a href=\"/web/findAll\">返回员工列表</a>");
				out.print("  	<hr/>");
				out.print("    <form action=\"/web/update\" method=\"post\">");
				out.print("    	<table>");
				out.print("    		<tr>");
				out.print("    			<td>编号:</td>");
				out.print("    			<td>");
				out.print("    				<input type=\"text\" name=\"id\" value=\""+id+"\" readonly=\"readonly\" />");
				out.print("    			</td>");
				out.print("    		</tr>");
				out.print("    		<tr>");
				out.print("    			<td>姓名:</td>");
				out.print("    			<td>");
				out.print("    				<input type=\"text\" name=\"name\" value=\""+name+"\" />");
				out.print("    			</td>");
				out.print("    		</tr>");
				out.print("    		<tr>");
				out.print("    			<td>工资:</td>");
				out.print("    			<td>");
				out.print("    				<input type=\"text\" name=\"salary\" value=\""+salary+"\" />");
				out.print("    			</td>");
				out.print("    		</tr>");
				out.print("    		<tr>");
				out.print("    			<td>性别:</td>");
				out.print("    			<td>");
				out.print("    				<input type=\"radio\" name=\"gender\" value=\"男\" "+("男".equals(gender) ? "checked" : "")+"/>男");
				out.print("    				<input type=\"radio\" name=\"gender\" value=\"女\" "+("女".equals(gender) ? "checked" : "")+"/>女");
				out.print("    			</td>");
				out.print("    		</tr>");
				out.print("    		<tr>");
				out.print("    			<td>教育背景:</td>");
				out.print("    			<td>");
				out.print("    				<select name=\"edu\">");
				out.print("    					<option value=\"-1\">--请选择--</option>");
				out.print("    					<option value=\"1\" "+("1".equals(edu)?"selected":"")+">高中</option>");
				out.print("    					<option value=\"2\" "+("2".equals(edu)?"selected":"")+">专科</option>");
				out.print("    					<option value=\"3\" "+("3".equals(edu)?"selected":"")+">本科</option>");
				out.print("    					<option value=\"4\" "+("4".equals(edu)?"selected":"")+">硕士</option>");
				out.print("    					<option value=\"5\" "+("5".equals(edu)?"selected":"")+">博士</option>");
				out.print("    				</select>");
				out.print("    			</td>");
				out.print("    		</tr>");
				out.print("    		<tr>");
				out.print("    			<td>兴趣爱好:</td>");
				out.print("    			<td>");
				out.print("    				<input type=\"checkbox\" name=\"hobbies\" value=\"1\" "+StringUtil.checkHobby(hobbies, "1")+">吃饭");
				out.print("    				<input type=\"checkbox\" name=\"hobbies\" value=\"2\" "+StringUtil.checkHobby(hobbies, "2")+">睡觉");
				out.print("    				<input type=\"checkbox\" name=\"hobbies\" value=\"3\" "+StringUtil.checkHobby(hobbies, "3")+">打豆豆");
				out.print("    			</td> ");
				out.print("    		</tr>");
				out.print("    		<tr>");
				out.print("    			<td>");
				out.print("    				<input type=\"submit\" value=\"修改\" />");
				out.print("    			</td>");
				out.print("    			<td>");
				out.print("    				<input type=\"reset\" value=\"重置\" />");
				out.print("    			</td>");
				out.print("    		</tr>");
				out.print("    	</table>");
				out.print("    </form>");
				out.print("  </body>");
				out.print("</html>");

			}
			
			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeAll(conn, ps, rs);
		}
		
		
		
		
		
		
		
	}
}
