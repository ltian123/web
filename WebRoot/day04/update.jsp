<%@ page language="java" import="java.util.*,entity.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/stringUtil" prefix="strUtil" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改员工信息</title>
  </head>
  <body>
  	<h1>修改员工信息</h1>
  	<a href="${pageContext.request.contextPath}/findAll.emp">返回员工列表</a>
  	<hr/>
  	<hr/>
  	<form action="${pageContext.request.contextPath}/update.emp">
  		<table border=1>
  			<tr>
  				<td>编号</td>
  				<td>
  					<input type="text" name="id" value="${emp.id }" readonly="readonly">
  				</td>
  			</tr>
  			<tr>
  				<td>姓名</td>
  				<td>
  					<input type="text" name="name" value="${emp.name }" />
  				</td>
  			</tr>
  			<tr>
  				<td>工资</td>
  				<td>
  					<input type="text" name="salary" value="${emp.salary }" />
  				</td>
  			</tr>
  			<tr>
  				<td>性别</td>
  				<td>
  					<input type="radio" name="gender" value="男" ${"男" eq emp.gender ? "checked" : "" }/>男
    				<input type="radio" name="gender" value="女" ${"女" eq emp.gender ? "checked" : "" }/>女
  				</td>
  			</tr>
  			<tr>
  				<td>教育背景</td>
  				<td>
  					<select name="edu">
    					<option value="-1">--请选择--</option>
    					<option value="1" ${"1" eq emp.edu ? "selected" : "" }>高中</option>
    					<option value="2" ${"2" eq emp.edu ? "selected" : "" }>专科</option>
    					<option value="3" ${"3" eq emp.edu ? "selected" : "" }>本科</option>
    					<option value="4" ${"4" eq emp.edu ? "selected" : "" }>硕士</option>
    					<option value="5" ${"5" eq emp.edu ? "selected" : "" }>博士</option>
    				</select>
  				</td>
  			</tr>
  			<tr>
  				<td>兴趣爱好</td>
  				<td>
  					<input type="checkbox" name="hobbies" value="1" ${strUtil:aa(emp.hob,"1") }>吃饭
    				<input type="checkbox" name="hobbies" value="2" ${strUtil:aa(emp.hob,"2") }>睡觉
    				<input type="checkbox" name="hobbies" value="3" ${strUtil:aa(emp.hob,"3") }>打豆豆
  				</td>
  			</tr>
  			<tr>
  				<td>
    				<input type="submit" value="修改" />
    			</td>
    			<td>
    				<input type="reset" value="重置" />
    			</td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
