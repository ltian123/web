<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>添加员工信息</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <form action="<%=request.getContextPath() %>/add.emp" method="post">
    	<table>
    		<tr>
    			<td>姓名:</td>
    			<td>
    				<input type="text" name="name" />
    			</td>
    		</tr>
    		<tr>
    			<td>工资:</td>
    			<td>
    				<input type="text" name="salary" />
    			</td>
    		</tr>
    		<tr>
    			<td>性别:</td>
    			<td>
    				<input type="radio" name="gender" value="男"/>男
    				<input type="radio" name="gender" value="女"/>女
    			</td>
    		</tr>
    		<tr>
    			<td>教育背景:</td>
    			<td>
    				<select name="edu">
    					<option value="-1">--请选择--</option>
    					<option value="1">高中</option>
    					<option value="2">专科</option>
    					<option value="3">本科</option>
    					<option value="4">硕士</option>
    					<option value="5">博士</option>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>兴趣爱好:</td>
    			<td>
    				<input type="checkbox" name="hobbies" value="1">吃饭
    				<input type="checkbox" name="hobbies" value="2">睡觉
    				<input type="checkbox" name="hobbies" value="3">打豆豆
    			</td> 
    		</tr>
    		<tr>
    			<td>
    				<input type="submit" value="添加" />
    			</td>
    			<td>
    				<input type="reset" value="重置" />
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>

