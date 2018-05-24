<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
  	function changecode(){
  		document.getElementById("image").src="<%=request.getContextPath()%>/show.code?id="+new Date().getTime();
  	}
  </script>
  </head>
  
  <body>
    <form action="<%=request.getContextPath()%>/check.code" method="post">
    	用户名:<input type="text" name="name" /><br/>
    	密码:<input type="password" name="password" /><br/>
    	验证码:<input type="text" name="code" />
    	<a href="javaScript:;" onclick="changecode()">
    		<img id="image" alt="图片加载失败" src="<%=request.getContextPath()%>/show.code">
    	</a>
    	<a href="javaScript:;">换一张</a><br/>
    	<input type="submit" value="登录"/>
    </form>
  </body>
</html>
