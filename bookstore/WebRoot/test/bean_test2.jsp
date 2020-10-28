<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<jsp:useBean id = "title" class = "bean.Title" scope = "page"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+
					request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%= basePath%>">
</head>
<body>
	自动获取表单参数并设置Bean对象属性的测试结果：<br>
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:setProperty property="*" name="title"/>
	书号：<jsp:getProperty property="isbn" name="title"/><br>
	书名：<jsp:getProperty property="title" name="title"/><br>
</body>
</html>