<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
			$("#sub").click(function(){
				//表单序列化
				let fd = $("#myform").serialize();
				$.post('/user53/AjaxAction?method=add',fd,function(data){
					alert(data.info);
					if(data.addCode>0){
						window.location.href = 'list.jsp';
					}
					
				},'json');
			});
			
		});
	</script>
  </head>
  
  <body>
    <h1>新增用户</h1>
	<form id="myform" method="post" action="javascript:void(0)" >
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
			<button id="sub">新增</button>
		</p>
	</form>
  </body>
</html>
