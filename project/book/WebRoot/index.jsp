<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%@ page import="com.service.*,com.service.impl.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.add{
			text-decoration:none;
			color:red;
			margin-left:380px;
		}
		.del{
			text-decoration:none;
		}
		.info{
			margin-left:690px;
		}
	</style>
	
	<script type="text/javascript" src="/book/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	$(function(){
		
		$("tr:even").attr("bgColor","#8AFFFE");
		$("#color").attr("bgColor","#86BFFF");
		
		$(document).on('click','.del',function(){
			if(confirm("是否删除")){
				let id = $(this).next().val();
				$.post("/book/BookAction?method=delete",{'id':id},function(data){
					alert(data.info);
					window.location.href = "/book/BookAction?method=main";
				},'json');
			}
		});
		
		let addCode = '${addCode}'
			if(addCode=='1'){
				alert('新增成功');
				window.location.href="/book/BookAction?method=main";//回到主页
			}else if(addCode=='0'){
				alert('新增失败');
				window.location.href="/book/add.jsp";//重新输入
			}
		
	});
	</script>
  </head>
  
  <body>
  <h1 class="info">图书信息</h1>
    <table id="tab" border="1" align="center" width="50%">
    	<thead>
			<tr id="color">
				<th>图书名称</th>
				<th>图书作者</th>
				<th>购买时间</th>
				<th>图书分类</th>
				<th>操作</th>
			</tr>
		</thead>
    	<tbody align="center">
    		<c:forEach var="b" items="${list}">
    			<tr>
					<td>${b.name}</td>
					<td>${b.author}</td>
					<td>${b.time}</td>
					<td>${b.type}</td>
					<td>
						<a class="del" href="javascript:void(0)">删除</a> <input type="hidden" value="${b.id}">
					</td>
				</tr>
    		</c:forEach>
    	</tbody>
    </table>
    	<a class="add" href="add.jsp">新增图书信息</a>
  </body>
  
</html>
