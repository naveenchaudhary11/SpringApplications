<%@ page import="java.util.ArrayList,java.util.List" %>
<%@ page import="com.tadigital.entity.Vendor" language="java" %>
<html>
	<head>
		<title>Spring Website</title>
	</head>
	
	<body>
		<%
			List<Vendor> vList = (ArrayList<Vendor>)session.getAttribute("VENDOR_LIST");
		%>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Username</th>
			</tr>
		<% 
			int i=0;
			for(Vendor v : vList){
				i++;
		%>
				<tr>
					<td><%= i  %></td>
					<td><%= v.getName() %></td>
					<td><%= v.getUname() %></td>
					<td><a href="edit<%= v.getId() %>">EDIT</a></td>
					<td><a href="delete<%= v.getId() %>">DELETE</a></td>
				</tr>
		<%
			}
		%>
		</table>
	</body>
</html>