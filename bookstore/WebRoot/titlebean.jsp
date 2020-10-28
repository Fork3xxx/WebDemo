<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="title" class="bean.Title" scope="page"></jsp:useBean>
	<%//Title title = new bean.Title(); %>
	<h1>JSP使用javaBean测试</h1>
	<hr>
	<%title.setIsbn("98780011");
	title.setTitle("JSP web原理");
	%>
	<h3>图书编号：<%=title.getIsbn()%><br>
		图书名称：<%=title.getTitle()%>
	</h3>
</body>
</html>