<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
    <h1>用户登录</h1>
    <hr/>
    
    <form action="<%=request.getContextPath() %>/login">
    	用户名:<input type="text" name="name" /><br/>
    	密码:<input type="password" name="password" /><br/>
    	<input type="submit" value="登录">
    	<span style="color: red;">
    	<%
    		String msg = (String)request.getAttribute("msg");
    		if(msg!=null){
    			out.print(msg);
    		}
    	%>
    	</span>
    </form>
    
  </body>
</html>
