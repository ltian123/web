package day02;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JDBCUtil;

public class DeleteEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ָ������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��ȡ�����еĲ���
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id==="+id);
		
		//���ݿ����
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
			
			//���û���Ӧ
			response.sendRedirect("/web/findAll");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeAll(conn, ps, null);
		}
		
		
	}
}
