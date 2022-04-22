<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'add.jsp' starting page</title>
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
			let addCode = '${addCode}'
			if(addCode=='1'){
				alert('新增成功');
				window.location.href="/user53/UserAction?method=main";//回到主页
			}else if(addCode=='0'){
				alert('新增失败');
				window.location.href="/user53/add.jsp";//重新输入
			}
			
		});
	</script>
</head>

<body>
	<h1>新增用户</h1>
	<form method="post" action="/user53/UserAction?method=add">
		<p>
			用户名<input type="text" name="uname" required>
		</p>
		<p>
			密码<input type="password" name="upwd" required>
		</p>
		<p>性别
			 <input type="radio" name="sex" value="1" checked>男
			 <input type="radio" name="sex" value="2">女
		</p>
		<p>
			身份证号<input type="text" name="cardNo" required>
		</p>
		<p>
			邮箱<input type="text" name="email" required>
		</p>
		<p>
			手机号<input type="text" name="mobile" required>
		</p>
		<p>
			<input type="submit" value="新增用户">
		</p>
	</form>
</body>
</html>
