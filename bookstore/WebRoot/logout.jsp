<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%session.removeAttribute("userName");//清掉session里面的用户名
		//跳转页面方法二
		response.sendRedirect("index.html");
	%>
</body>
</html>