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
	<script type="text/javascript" src="/book/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#sub").click(function(){
				yz();
			});
		});
		
		function yz(){
			var name = document.getElementById("name");
			var nameval = name.value;
			var author = document.getElementById("author");
			var authorval = author.value;
			if(authorval=='' || nameval==''){
				alert("图书名称和作者姓名不能为空")
			}
			
			var timepattern = /^\d{4}-[0-1]{1}[0-9]{1}-[0-2]{1}[0-9]{1}/;
			var time = document.getElementById("time");
			var timeval = time.value;
			if(!timepattern.test(timeval)){
				alert("日期格式错误");
			}
		
			var type = document.getElementById("tu");
			var typeval = type.value;
			if(typeval=='0'){
				alert("请选择图书类型")
			}
		}
	</script>
  </head>
  
  <body>
    <h1>新增图书信息</h1>
	<form method="post" action="/book/BookAction?method=add">
		<p>
			图书名称 &nbsp;&nbsp;<input type="text" id="name" name="name" value="">
		</p>
		<p>
			图书作者&nbsp;&nbsp;<input type="text" id="author" name="author" value="">
		</p>
		<p>
			 购买日期&nbsp;&nbsp;<input type="text" id="time" name="time">yyyy-MM-dd格式
		</p>
		<p>
			图书类型&nbsp;&nbsp;<select name="type" id="tu">
					<option selected="selected" value="0">选择所属分类</option>
					<option value="1">计算机/软件</option>
					<option value="2">小说/文摘</option>
					<option value="3">杂项</option>
				</select>
		</p>
		<p>
			<input id="sub" type="submit" value="新增图书">
		</p>
	</form>
  </body>
</html>
