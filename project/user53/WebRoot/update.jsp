<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.service.*,com.service.impl.*,com.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/user53/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	$(function(){
		let updateCode = '${updateCode}'
		if(updateCode=='1'){
			alert('修改成功');
			window.location.href="/user53/UserAction?method=main";//回到主页
		}else if(updateCode=='0'){
			alert('修改失败,请重新输入');
			window.location.href="/user53/UserAction?method=one?usid=${uo.usid}";//重新输入
		}
		
	});
	</script>
  </head>
  
  <body>
    <h1>修改用户</h1>
    <form method="post" action="/user53/UserAction?method=update">
    	<input type="hidden" name="usid" value="${uo.usid}">
		<p>
			用户名<input type="text" name="uname" value="${uo.uname}" required>
		</p>
		<p>
			密码<input type="password" name="upwd" value="${uo.upwd}" required>
		</p>
		<p>性别
		<c:if test="${uo.sex=='1'}" >
			 <input type="radio" name="sex" value="1" checked>男
			 <input type="radio" name="sex" value="2">女
		</c:if>
		<c:if test="${uo.sex=='2'}" >
			 <input type="radio" name="sex" value="1">男
			 <input type="radio" name="sex" value="2" checked>女
		</c:if>
		</p>
		<p>
			身份证号<input type="text" name="cardNo" value="${uo.cardNo}" required>
		</p>
		<p>
			邮箱<input type="text" name="email" value="${uo.email}" required>
		</p>
		<p>
			手机号<input type="text" name="mobile" value="${uo.mobile}" required>
		</p>
		<p>
			<input type="submit" value="修改用户">
		</p>
	</form>
  </body>
</html>
