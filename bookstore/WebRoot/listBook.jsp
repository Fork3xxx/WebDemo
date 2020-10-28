<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="bean.*,java.util.*" %>
<<jsp:useBean id="dao" class="bean.TitleDaoImpl" scope="request"/>
<html>
<head>
  <title>图书列表</title>
</head>
<body>
 <table  bgcolor=lightgrey>
<tr><td>ISBN</td><td>书名</td><td>版本</td><td>出版时间</td><td>价格</td></tr> 
<% 
   //Connection dbCon = dbcon.getConnection();
   //Statement stmt = dbCon.createStatement();  
   //ResultSet rs = stmt.executeQuery("select * from titles");
 
  // while (rs.next()) {
	List list=dao.getTitles();
	Title book= null;
	for(int i = 0; i<list.size();i++){
		book = (Title)list.get(i);
	
      %>
      <tr  bgcolor=cyan>
      		<td><a href="./ToEditTitle?isbn=<%=book.getIsbn() %>" title="单击进入编辑"><%=book.getIsbn()%></a></td>
      		<td><%=book.getTitle()%></td>
     		<td><%=book.getEditionNumber() %></td>
     		<td> <%=book.getCopyright() %> </td>
     		<td><%=book.getPrice()  %></td>
    
   	</tr>
      <%}
        //rs.close();
        //stmt.close();
	//dbCon.close();
      %>
</table>
</body>
</html>