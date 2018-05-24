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
		//ָ������
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
		
		
		/*//��ȡ�����еĲ���
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
		
		//�����ݱ��浽���ݿ�
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//ע������
//			Class.forName(JDBCConstant.JDBC_DRIVER);
			//��ȡ����
//			conn = DriverManager.getConnection(JDBCConstant.JDBC_CONNECTION_URL, JDBCConstant.JDBC_CONNECTION_USERNAME, JDBCConstant.JDBC_CONNECTION_PASSWORD);
//			conn.setAutoCommit(false);
			//���ݿ�������
//			String sql = new StringBuffer()
//					.append("insert into t_emp ")
//					.append("(name,salary,gender,edu,hobbies) ")
//					.append("values(?,?,?,?,?) ")
//					.toString();
			//��ȡ״̬��
//			ps = conn.prepareStatement(sql);
			//����
//			ps.setString(1, name);
//			ps.setDouble(2, salary);
//			ps.setString(3, gender);
//			ps.setString(4, edu);
//			ps.setString(5, StringUtil.arrayToString(hobbies, ","));
//			ps.executeUpdate();
//			conn.commit();
			//������Ӧ���ظ������
//			out.print("<h1><font color='green'>��ϲ��,"+name+"�û���Ϣ��ӳɹ�</font></h1>");
//			request.getRequestDispatcher("url��ַ").forward(request, response);
//			response.sendRedirect("url��ַ");
//			response.sendRedirect("/web/findAll");
//			response.sendRedirect("http://bbs.itany.com");
//			request.getRequestDispatcher("/findAll").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			//������Ӧ����������
//			out.print("<h1><font color='red'>�Բ���,"+name+"�û���Ϣ���ʧ��</font></h1>");
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
