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
		out.print("    <title>���Ա����Ϣ</title>");
		out.print("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
		out.print("  </head>");
		out.print("  <body>");
		out.print("    <form action=\"/web/addEmp\" method=\"post\">");
		out.print("    	<table>");
		out.print("    		<tr>");
		out.print("    			<td>����:</td>");
		out.print("    			<td>");
		out.print("    				<input type=\"text\" name=\"name\" />");
		out.print("    			</td>");
		out.print("    		</tr>");
		out.print("    		<tr>");
		out.print("    			<td>����:</td>");
		out.print("    			<td>");
		out.print("    				<input type=\"text\" name=\"salary\" />");
		out.print("    			</td>");
		out.print("    		</tr>");
		out.print("    		<tr>");
		out.print("    			<td>�Ա�:</td>");
		out.print("    			<td>");
		out.print("    				<input type=\"radio\" name=\"gender\" value=\"��\"/>��");
		out.print("    				<input type=\"radio\" name=\"gender\" value=\"Ů\"/>Ů");
		out.print("    			</td>");
		out.print("    		</tr>");
		out.print("    		<tr>");
		out.print("    			<td>��������:</td>");
		out.print("    			<td>");
		out.print("    				<select name=\"edu\">");
		out.print("    					<option value=\"-1\">--��ѡ��--</option>");
		out.print("    					<option value=\"1\">����</option>");
		out.print("    					<option value=\"2\">ר��</option>");
		out.print("    					<option value=\"3\">����</option>");
		out.print("    					<option value=\"4\">˶ʿ</option>");
		out.print("    					<option value=\"5\">��ʿ</option>");
		out.print("    				</select>");
		out.print("    			</td>");
		out.print("    		</tr>");
		out.print("    		<tr>");
		out.print("    			<td>��Ȥ����:</td>");
		out.print("    			<td>");
		out.print("    				<input type=\"checkbox\" name=\"hobbies\" value=\"1\">�Է�");
		out.print("<input type=\"checkbox\" name=\"hobbies\" value=\"2\">˯��");
		out.print(" <input type=\"checkbox\" name=\"hobbies\" value=\"3\">�򶹶�");
		out.print("    			</td> ");
		out.print("    		</tr>");
		out.print("    		<tr>");
		out.print("    			<td>");
		out.print("    				<input type=\"submit\" value=\"���\" />");
		out.print("    			</td>");
		out.print("    			<td>");
		out.print("    				<input type=\"reset\" value=\"����\" />");
		out.print("    			</td>");
		out.print("    		</tr>");
		out.print("    	</table>");
		out.print("    </form>");
		out.print("  </body>");
		out.print("</html>");

	}
}
