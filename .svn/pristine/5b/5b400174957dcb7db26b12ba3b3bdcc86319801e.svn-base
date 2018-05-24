<%@ page language="java" import="java.util.*,entity.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>员工列表</title>
  </head>
  
  <body>
  <h1>员工列表</h1>
  <a href="${pageContext.request.contextPath}/day03/addEmp.jsp">添加员工信息</a>
  <hr/>
  
  <table border="1">
  	<tr>
  		<th>编号</th>
  		<th>姓名</th>
  		<th>工资</th>
  		<th>操作</th>
  	</tr>
  	
  	<c:forEach items="${emps }" var="emp">
  		<tr>
  			<td>${emp.id }</td>
  			<td>${emp.name }</td>
  			<td>${emp.salary }</td>
  			<td>
	  			<a href="${pageContext.request.contextPath}/findById.emp?id=${emp.id}">修改</a>
	  			<a href="${pageContext.request.contextPath}/deleteById.emp?id=${emp.id}" onclick="return confirm('是否确认删除')">删除</a>
	  		</td>
  		</tr>
  	</c:forEach>
  	
  	
<%--  	<%--%>
<%--  		List<Emp> emps = (List<Emp>)request.getAttribute("emps");--%>
<%--  		for(Emp emp : emps){--%>
<%--  	%>--%>
<%--  	<tr>--%>
<%--  		<td><%=emp.getId() %></td>--%>
<%--  		<td><%=emp.getName() %></td>--%>
<%--  		<td><%=emp.getSalary() %></td>--%>
<%--  		<td>--%>
<%--  			<a href="${pageContext.request.contextPath}/findById.emp?id=<%=emp.getId() %>">修改</a>--%>
<%--  			<a href="${pageContext.request.contextPath}/deleteById.emp?id=<%=emp.getId() %>" onclick="return confirm('是否确认删除')">删除</a>--%>
<%--  		</td>--%>
<%--  	</tr>--%>
<%--	<%--%>
<%--  		}--%>
<%--	%>  --%>
  </table>
  
  
  
  </body>
</html>
