<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
			let usid = '${param.usid}';

			let pnode = $("#myform");
			
			
			$.post("/user53/AjaxAction?method=updateOne",{'usid':usid},function(data){
				let p1 = $("<p>用户名<input type='text' name='uname' value='"+data.uo.uname+"' required></p>");
				pnode.append(p1);
				let p2 = $("<p>密码<input type='password' name='upwd' value='"+data.uo.upwd+"' required></p>");

				pnode.append(p2);
				if(data.uo.sex=='1'){
					let p3 = $("<p><input type='radio' name='sex' value='1' checked>男<input type='radio' name='sex' value='2'>女</p>");

					pnode.append(p3);
				}else if(data.uo.sex=='2'){
					let p3 = $("<p><input type='radio' name='sex' value='1'>男<input type='radio' name='sex' value='2' checked>女</p>");

					pnode.append(p3);
				}
				let p4 = $("<p>身份证号<input type='text' name='cardNo' value='"+data.uo.cardNo+"' required></p>");

				pnode.append(p4);
				let p5 = $("<p>邮箱<input type='text' name='email' value='"+data.uo.email+"' required></p>");

				pnode.append(p5);
				let p6 = $("<p>手机号<input type='text' name='mobile' value='"+data.uo.mobile+"' required></p>");

				pnode.append(p6);
				let p7 = $("<p><button id='sub'>修改</button></p>");

				pnode.append(p7);
				
			},'json');
			
			
			$(document).on('click','#sub',function(){
				let fd = $("#myform").serialize();
				
				$.post('/user53/AjaxAction?method=update&usid='+usid,fd,function(data){
					alert(data.info);
					window.location.href = 'list.jsp';
				},'json');
			});
			
		});
		
	</script>
  </head>
  
  <body>
    <h1>修改用户</h1>
	<form id="myform" method="post" action="javascript:void(0)" >
		
	</form>
  </body>
</html>
