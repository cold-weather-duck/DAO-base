<%@ page language="java" import="java.util.*,com.entity.*"
	pageEncoding="UTF-8"%>
<%@ page import="com.service.*,com.service.impl.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<script type="text/javascript" src="/user53/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
		$(function(){
			//alert(0);
			$(document).on('click','.del',function(){
				let vs = $(this).next().val();
				if(confirm("是否删除?")){
					window.location.href = '/user53/UserAction?method=delete&usid='+vs;
				}
			});
			// 
			<%-- let deleteCode = '<%= request.getAttribute("deleteCode")%>'; --%>
			 let deleteCode = '${deleteCode}';
			if(deleteCode == '1'){
				 alert("删除成功");
				 window.location.href = '/user53/UserAction?method=main';
			}else if(deleteCode == '0'){
				alert("删除失败");
				window.location.href = '/user53/UserAction?method=main';
			}
			//跳转页面
				$("#jump").click(function(){
					let vs = $("#pno").val();
					window.location.href ="/user53/UserAction?method=main&pno="+vs;
				});
			//
			$("#selectPno").change(function(){
				 let vs = $(this).val();
				 window.location.href ="/user53/UserAction?method=main&pno="+vs;
			})
			
			//
		})
	</script>
</head>

<body>
	<h1>
		<a href="/user53/el.jsp">el语法测试</a>
	</h1>
	<h1>
		<a href="/user53/Ajax/list.jsp">Ajax测试</a>
	</h1>
	<h1>
		<a href="/user53/page/upload.jsp">文件上传测试</a>
	</h1>
	<h1>
		<a href="add.jsp">新增用户</a>
	</h1>
	<h1>
		<a href="Ajax/register.jsp">用户注册</a>
	</h1>
	<h1 style="color:red;">欢迎${userInfo.uname}的到来</h1>
	<h1>用户列表</h1>
	<table border="1" align="center" width="80%">
		<thead>
			<tr>
				<th>编码</th>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证</th>
				<th>邮箱</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="u" items="${hm.list}">
				<tr>
					<td>
						<%-- a标签传值 --%> <a href="/user53/UserAction?method=one&usid=${u.usid }">${u.usid }<a />
					</td>
					<td>${u.uname }</td>
					<td>${u.sex }</td>
					<td>${u.cardNo }</td>
					<td>${u.email}</td>
					<td>
						<button class="del">删除</button> <input type="hidden"
						value="${u.usid }">
					</td>
				</tr>

			</c:forEach>

		</tbody>
		<tfoot>
			<tr>
				<td colspan="6">&nbsp;共${hm.all}条记录&nbsp;
					&nbsp;[${hm.pagenum}/${hm.pagecount}]&nbsp; &nbsp;<a
					href="/user53/UserAction?method=main&pno=1">首页</a>&nbsp; &nbsp;<a
					href="/user53/UserAction?method=main&pno=${hm.pagenum - 1}">上一页</a>&nbsp; &nbsp;<a
					href="/user53/UserAction?method=main&pno=${hm.pagenum + 1}">下一页</a>&nbsp; &nbsp;<a
					href="/user53/index.jsp?pno=${hm.pagecount}">末页</a>&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="number" id="pno" name="pno" />&nbsp;
					<button id="jump">GO</button> <select id="selectPno"
					name="selectPno">

						<c:forEach var="i" items="${numList}">
							<c:if test="${i == hm.pagenum }">
								<option value="${i}" selected>${i}</option>
							</c:if>

							<c:if test="${i != hm.pagenum }">
								<option value="${i}" selected>${i}</option>
							</c:if>
						</c:forEach>

				</select>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>
