<%@page import="conn.ConnectDB"%>
<%@page import="bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css" />
<title>SONAT-Test</title>
</head>
<body>
	 <% ArrayList<User> list = new ConnectDB().getUser(); %>
	 <h1 align="center">List User</h1>
	 <a href="insert.jsp">Insert New</a>
	 <table width="100%" align="center">
		 <tr>
			 <th>ID</th>
			 <th>Name</th>
			 <th>Gender</th>
			 <th>Age</th>
		 </tr>
		 <%
		 for(User user : list){
			 String gen = null;
			 if(user.getGen().compareTo("F")==0) gen="Female";
			 else gen="Male";
			 String editURL = "edit.jsp?id="+user.getId();
			 String deleteURL = "delete?id="+user.getId();
			 %>
			 <tr>
				 <td align="center"><%=user.getId() %></td>
				 <td align="center"><%=user.getName() %></td>
				 <td align="center"><%= gen %></td>
				 <td align="center"><%=user.getAge() %></td>
				 <td align="center"><a href="<%=editURL%>">Edit</a></td>
				 <td align="center"><a href=<%=deleteURL%>>Delete</a></td>
			 </tr>
		<% } %>
	 </table>
</body>
</html>