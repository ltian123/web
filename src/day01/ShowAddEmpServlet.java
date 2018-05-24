package day01;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAddEmpServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("  <head>");
		out.print("    <title>添加员工信息</title>");
		out.print("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
		out.print("  </head>");
		out.print("  <body>");
		out.print("    <form action=\"/web/addEmp\" method=\"post\">");
		out.print("    	<table>");
		out.print("    		<tr>");
		out.print("    			<td>姓名:</td>");
		out.print("    			<td>");
		out.print("    				<input type=\"text\" name=\"name\" />");
		out.print("    			</td>");
		out.print("    		</tr>");
		out.print("    		<tr>");
		out.print("    			<td>工资:</td>");
		out.print("    			<td>");
		out.print("    				<input type=\"text\" name=\"salary\" />");
		out.print("    			</td>");
		out.print("    		</tr>");
		out.print("    		<tr>");
		out.print("    			<td>性别:</td>");
		out.print("    			<td>");
		out.print("    				<input type=\"radio\" name=\"gender\" value=\"男\"/>男");
		out.print("    				<input type=\"radio\" name=\"gender\" value=\"女\"/>女");
		out.print("    			</td>");
		out.print("    		</tr>");
		out.print("    		<tr>");
		out.print("    			<td>教育背景:</td>");
		out.print("    			<td>");
		out.print("    				<select name=\"edu\">");
		out.print("    					<option value=\"-1\">--请选择--</option>");
		out.print("    					<option value=\"1\">高中</option>");
		out.print("    					<option value=\"2\">专科</option>");
		out.print("    					<option value=\"3\">本科</option>");
		out.print("    					<option value=\"4\">硕士</option>");
		out.print("    					<option value=\"5\">博士</option>");
		out.print("    				</select>");
		out.print("    			</td>");
		out.print("    		</tr>");
		out.print("    		<tr>");
		out.print("    			<td>兴趣爱好:</td>");
		out.print("    			<td>");
		out.print("    				<input type=\"checkbox\" name=\"hobbies\" value=\"1\">吃饭");
		out.print("<input type=\"checkbox\" name=\"hobbies\" value=\"2\">睡觉");
		out.print(" <input type=\"checkbox\" name=\"hobbies\" value=\"3\">打豆豆");
		out.print("    			</td> ");
		out.print("    		</tr>");
		out.print("    		<tr>");
		out.print("    			<td>");
		out.print("    				<input type=\"submit\" value=\"添加\" />");
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
}
