<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.service.*,com.service.impl.*,com.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	int num = 19;
	pageContext.setAttribute("num", num);

	IUserService is = new UserService();

	List<Users> ulist = is.selectAll();
	request.setAttribute("ulist", ulist);

	Users u1 = is.selectOne(11);

	request.setAttribute("u1", u1);//放入作用域

	request.setAttribute("ss", "ok");

	String js = "<script>alert('hehe')</script>";
	request.setAttribute("js", js);
	
	request.setAttribute("times",new Date());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>ELELELELELELELEL</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h2>
		表达式输出---<%=num%>
	</h2>
	<h2>el表达式是从四大作用域 中取的 page request session application 同名参数就近原则</h2>
	<h2>el num : ${num}</h2>
	<h2>
		名字1---<%=u1.getUname()%></h2>
	<h2>名字2---${u1.uname}</h2>
	<h2>名字3---${u1["uname"]}</h2>
	<h2>empty num --- ${empty num}</h2>
	<h2>not empty num --- ${not empty num}</h2>
	<h2>ss eq ok ${ss == 'ok'}</h2>
	<h2>ss eq ok ${ss eq 'ok'}</h2>
	<hr />

	<%--<h2>js1:${js}</h2>--%>
	<h2>
		js1:---
		<c:out value="${js}" />
	</h2>
	<c:set var="info" value="天天向上" scope="request" />
	<h2>info : ${requestScope.info}</h2>
	<c:remove var="info" scope="request" />
	<h2>info : ${requestScope.info}</h2>
	<c:if test="${num>=20}">
		<h2>num >= 20</h2>
	</c:if>
	<c:if test="${num<20}">
		<h2>wxx</h2>
	</c:if>
	<hr/>
	<table align="center" border="1" width="50%">

		<c:forEach var="uo" items="${ulist}" varStatus="vst">
			
			<tr
			<c:if test="${vst.index % 2 == 0}">
				style="background:red"
			</c:if>
			>
				<td>${uo.usid} --- ${vst.index} </td>
				<td>${uo.uname}</td>
				<td>${uo.sex}</td>
			
			</tr>
			
		</c:forEach>
		
	</table>
	<hr/>
	
	<h2>times:${times}</h2>
	<h2>times:<fmt:formatDate value="${times}" pattern="yyyy-MM-dd HH:mm:ss" /></h2>
	<hr/>
</body>
</html>
