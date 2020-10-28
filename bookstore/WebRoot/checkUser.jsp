<%@ page language="java" import="java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <<jsp:useBean id="db" class="bean.DBcon" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录验证界面[checkUser.jsp]</title>
</head>
<body>
<%
	request.setCharacterEncoding("GBK"); 		//解决post提交的中文乱码
	String name = request.getParameter("loginName");
	String password = request.getParameter("password");
%>
    你输入的用户名是：<%= name %><br><br>
<%
	Connection con = db.getConnection();
	//Statement stmt = con.createStatement();
	String sql = "select * from userinfo where loginname =? and password=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, password);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next())									//验证通过
	{												//将用户名保存到session中
		session.setAttribute("userName", name);
		response.sendRedirect("main.jsp");
	}
	else{										//验证未通过
		out.print("无此用户或密码有误，登录失败！<br><br>");
		out.print("<a href = 'index.html'>重新登录<//a>");
	}
%>
</body>
</html>