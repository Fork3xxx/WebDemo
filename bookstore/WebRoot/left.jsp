<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <% String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+"://"+request.getServerPort()+path+"/";
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> </title>
</head>
<body>
 <font>当前用户：<%= request.getSession().getAttribute("userName") %><a href="logout.jsp" target="_parent">退出</a></font><hr>
 	<font color="red" size="4" style="font-family:simhei">前台系统</font><hr>
 	<a href=viewBook.jsp target=main>浏览图书</a><br><br>
 	<font color="red" size="4" style="font-family:simhei">后台系统</font><hr>
 	<a href=listBook.jsp target=main>书架维护</a>
</body>
</html>