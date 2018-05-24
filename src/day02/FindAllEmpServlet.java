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

public class FindAllEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ָ����Ӧҳ��ı����Լ��ı�����
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//���ݿ����
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = new StringBuffer()
						.append("select id,name, ")
						.append("salary,gender, ")
						.append("edu,hobbies ")
						.append("from t_emp")
						.toString();
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("  <head>");
			out.print("    <title>��ѯԱ����Ϣ</title>");
			out.print("    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
			out.print("  </head>");
			out.print("  <body>");
			out.print("  	<h1>Ա���б�</h1>");
			out.print("  	<a href=\"/web/day01/addEmp.html\">���Ա����Ϣ</a>");
			out.print("  	<hr/>");
			out.print("    <table border=\"1\">");
			out.print("    	<tr>	");
			out.print("    		<th>���</th>");
			out.print("    		<th>����</th>");
			out.print("    		<th>����</th>");
			out.print("    		<th>����</th>");
			out.print("    	</tr>");
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				out.print("    	<tr>");
				out.print("    		<td>"+id+"</td>");
				out.print("    		<td>"+name+"</td>");
				out.print("    		<td>"+salary+"</td>");
				out.print("    		<td>");
				out.print("    			<a href=\"/web/findById?id="+id+"\">�޸�</a>");
				out.print("    			<a href=\"/web/deleteById?id="+id+"\"onclick=\"return confirm('�Ƿ�ȷ��ɾ��')\">ɾ��</a>");
				out.print("    		</td>");
				out.print("    	</tr>");
			}
			
			out.print("    </table>");
			out.print("  </body>");
			out.print("</html>");
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeAll(conn, ps, rs);
			
		}
		
		
		
		

		
		
		
		
	}
}
