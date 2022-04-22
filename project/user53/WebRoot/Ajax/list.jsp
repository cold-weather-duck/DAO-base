<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'list.jsp' starting page</title>
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
			showTable();
			
			$(document).on('click','.del',function(){
				if(confirm("是否删除")){
					let id = $(this).next().val();
					$.post("/user53/AjaxAction?method=delete",{'usid':id},function(data){
						alert(data.info);
						if(data.deleteCode>0){
							showTable();//调方法刷新页面
						}
						
					},'json');
				}
			});
			
		});
		
		//显示表格
		function showTable(){
			let pnode = $("#mytab > tbody");
				pnode.empty();//清空tbody
			
			//发Ajax
			$.post("/user53/AjaxAction",{'method':'list'},function(data){
				
				//回调函数
				$.each(data,function(i,n){
					let trnode = $("<tr></tr>");
					
					let td1 = $("<td><a href='update.jsp?usid="+n.usid+"'>"+n.usid+"</a></td>");
					let td2 = $("<td>"+n.uname+"</td>");
					let td3 = $("<td>"+n.sex+"</td>");
					let td4 = $("<td>"+n.email+"</td>");
					let td5 = $("<td>"+n.mobile+"</td>");
					trnode.append(td1);
					trnode.append(td2);
					trnode.append(td3);
					trnode.append(td4);
					trnode.append(td5);
					
					let td6 = "<td>";
						td6 += "<button class='del'>删除</button>";
						td6 += "<input type='hidden' value='"+n.usid+"' />";
						td6 += "</td>";
						td6 = $(td6);
					trnode.append(td6);
					
					pnode.append(trnode);
				});
				
			},'json');
			
		}
</script>
</head>

<body>
	<h1>Ajax测试</h1>
	<h1><a href="add.jsp">新增</a></h1>
	<table id="mytab" border="1" align="center" width="80%">
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>邮箱</th>
				<th>手机</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
</body>
</html>
