<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/user53/js/jquery-1.12.4.js"></script>
	<script	type="text/javascript">
		$(function(){
			let loginCode = '${loginCode}';
			if(loginCode==1){
				alert("用户名或者密码错误")
				window.location.href="/user53/login.jsp";
			}
		})
	</script>
  </head>
  
  <body>
    <h1>登录页面</h1>
    <form action="/user53/UserAction?method=login" method="post">
    	<p>用户名 <input type="text" name="uname" /></p>
    	<p>密码 <input type="password" name="upwd" /></p>
    	<p><input type="submit" value="提交" /></p>
    </form>
  </body>
</html>
