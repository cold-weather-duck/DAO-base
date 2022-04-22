<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <script type="text/javascript" src="/user53/js/jquery-1.12.4.js"></script>
   <script type="text/javascript" src="/user53/ckeditor/ckeditor.js"></script>
  </head>
  
  <body>
    <h1>文件上传测试</h1>
    <form action="/user53/page/UploadAction" method="post" enctype="multipart/form-data">
     <p>标题：<input type="text" name="title" /> </p>
     <p>文件: <input type="file" name="ff" /> </p> 
     <p>
                  介绍：
          <textarea id="info" name="info" class="ckeditor" rows="5" cols="30"></textarea>        
     </p>
     <p> <input type="submit" value="文件上传" /> </p>
    </form>
  </body>
</html>
